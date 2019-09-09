package Servlets.Film;

import DAO.FilmActorDAO;
import DAO.impl.DAOImpl;
import DAO.impl.FilmActorDAOImpl;
import model.FilmActor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 13.04.2019.
 */
@WebServlet("/deleteRole")
public class DeleteRoleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmActorDAO filmActorDAO=new FilmActorDAOImpl(DAOImpl.getInstance());
        if(req.getParameter("filmId")!=null&&req.getParameter("actorId")!=null){
            int filmId=Integer.parseInt(req.getParameter("filmId"));
            int actorId=Integer.parseInt(req.getParameter("actorId"));
            filmActorDAO.deleteFilmActor(new FilmActor(filmId,actorId));
        }
        resp.sendRedirect("roleList?filmId="+req.getParameter("filmId"));
    }
}
