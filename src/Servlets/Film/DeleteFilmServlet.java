package Servlets.Film;

import DAO.FilmDAO;
import DAO.impl.DAOImpl;
import DAO.impl.FilmDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 08.04.2019.
 */
@WebServlet("/deleteFilm")
public class DeleteFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FilmDAO filmDao=new FilmDAOImpl(DAOImpl.getInstance());
        if(req.getParameter("filmId")!=null) {
            int filmId=Integer.parseInt(req.getParameter("filmId"));
            filmDao.deleteFilm(filmId);
        }
        resp.sendRedirect("filmList");
    }

}
