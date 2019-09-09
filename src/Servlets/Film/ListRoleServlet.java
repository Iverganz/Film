package Servlets.Film;

import DAO.DAO;
import DAO.FilmActorDAO;
import DAO.FilmDAO;
import DAO.impl.DAOImpl;
import DAO.impl.FilmActorDAOImpl;
import DAO.impl.FilmDAOImpl;
import model.Actor;
import model.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by пользователь on 13.04.2019.
 */
@WebServlet("/roleList")
public class ListRoleServlet extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    DAOImpl.initInstance();
    DAO dao=DAOImpl.getInstance();
    dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
    dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
    int filmId;
    FilmActorDAO filmActorDAO=new FilmActorDAOImpl(dao);
    FilmDAO filmDAO=new FilmDAOImpl(dao);
    if(req.getParameter("filmId")!=null) {
        filmId = Integer.parseInt(req.getParameter("filmId"));
        HashMap<Actor,String> roles=filmActorDAO.getActorsByFilm(filmId);
        Film film=filmDAO.getFilm(filmId);
        req.getSession().setAttribute("roles",roles);
        req.getSession().setAttribute("film",film);
    }
    req.getRequestDispatcher("roleList.jsp").forward(req,resp);
}
protected void  doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
}
}
