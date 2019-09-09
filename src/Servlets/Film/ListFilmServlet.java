package Servlets.Film;

import DAO.DAO;
import DAO.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DAO.FilmDAO;
import model.Film;
import DAO.DirectorDAO;
import DAO.CompanyDAO;
import DAO.FilmActorDAO;
/**
 * Created by пользователь on 08.04.2019.
 */
@WebServlet("/filmList")
public class ListFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOImpl.initInstance();
        DAO dao=DAOImpl.getInstance();
        dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
        dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
        FilmDAO filmDao=new FilmDAOImpl(dao);
        List<Film> films=filmDao.getFilms();
        DirectorDAO directorDAO=new DirectorDAOImpl(dao);
        CompanyDAO companyDAO=new CompanyDAOImpl(dao);
        FilmActorDAO filmActorDAO=new FilmActorDAOImpl(dao);
        req.getSession().setAttribute("companyDAO",companyDAO);
        req.getSession().setAttribute("directorDAO",directorDAO);
        req.getSession().setAttribute("filmActorDAO",filmActorDAO);
        req.getSession().setAttribute("films",films);
        req.getRequestDispatcher("filmList.jsp").forward(req,resp);

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
