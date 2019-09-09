package Servlets.Film;

import DAO.DAO;
import DAO.FilmActorDAO;
import DAO.impl.ActorDaoImpl;
import DAO.impl.DAOImpl;
import DAO.impl.FilmActorDAOImpl;
import DAO.impl.FilmDAOImpl;
import model.Actor;
import model.Film;
import model.FilmActor;
import DAO.FilmDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DAO.ActorDao;

/**
 * Created by пользователь on 13.04.2019.
 */
@WebServlet("/editRoles")
public class EditRoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOImpl.initInstance();
        DAO dao=DAOImpl.getInstance();
        dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
        dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
        FilmActor filmActor=null;
        FilmActorDAO filmActorDAO=new FilmActorDAOImpl(dao);
        ActorDao actorDao=new ActorDaoImpl(dao);
        List<Actor> actors=actorDao.getActors();
        int filmId;
        int actorId;
        Film film=null;
        if(req.getParameter("actorId")!=null&&req.getParameter("filmId")!=null){
            filmId=Integer.parseInt(req.getParameter("filmId"));
            actorId=Integer.parseInt(req.getParameter("actorId"));
            filmActor=filmActorDAO.getFilmActor(filmId,actorId);
            FilmDAO filmDAO=new FilmDAOImpl(dao);

            film=filmDAO.getFilm(filmId);
        }
        req.getSession().setAttribute("role",filmActor);
        req.getSession().setAttribute("film",film);
        req.getSession().setAttribute("actors",actors);
        req.getSession().setAttribute("actorDAO",actorDao);
        req.getRequestDispatcher("editRoles.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int actorId;
        String id=req.getParameter("idFilm");
        //int filmId=Integer.parseInt(req.getParameter("idFilm"));
        String role;
        DAO dao=DAOImpl.getInstance();
        FilmActorDAO filmActorDAO=new FilmActorDAOImpl(dao);
        FilmActor filmActor=(FilmActor) req.getSession().getAttribute("role");
        Film film=(Film)req.getSession().getAttribute("film");
        filmActorDAO.deleteFilmActor(filmActor);
        if(req.getParameter("actorSelect")!=null){
            if(req.getParameter("roleName")=="") role="неизвестная роль";
            else role=req.getParameter("roleName");
            actorId=Integer.parseInt(req.getParameter("actorSelect"));
            //filmId=Integer.parseInt(req.getParameter("idFilm"));
            //filmActor.setIdFilm(filmId);
            filmActor.setIdActor(actorId);
            filmActor.setRole(role);
            filmActorDAO.addFilmActor(filmActor);
        }
        resp.sendRedirect("/roleList?filmId="+filmActor.getIdFilm());
    }
}
