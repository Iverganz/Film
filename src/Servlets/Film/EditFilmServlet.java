package Servlets.Film;

import DAO.DAO;
import DAO.FilmActorDAO;
import DAO.FilmDAO;
import DAO.impl.*;
import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import DAO.DirectorDAO;
import DAO.CompanyDAO;
/**
 * Created by пользователь on 13.04.2019.
 */
@WebServlet("/editFilm")
public class EditFilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Film film=null;
        FilmDAO filmDAO=new FilmDAOImpl(DAOImpl.getInstance());
        int filmId;
        DAOImpl.initInstance();
        DAO dao=DAOImpl.getInstance();
        dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
        dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
        DirectorDAO directorDao=new DirectorDAOImpl(dao);
        List<Director> directors=directorDao.getDirectors();
        req.setAttribute("directors",directors);
        req.setAttribute("dirDAO",directorDao);
        CompanyDAO companyDAO=new CompanyDAOImpl(dao);
        List<Company> companies=companyDAO.getCompanies();
        req.setAttribute("companies",companies);
        req.setAttribute("coDAO",companyDAO);
        if(req.getParameter("filmId")!=null){
            filmId=Integer.parseInt(req.getParameter("filmId"));

            film=filmDAO.getFilm(filmId);
        }
        req.getSession().setAttribute("film",film);
        req.getRequestDispatcher("editFilm.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Director director;
        Company company;
        String filmName;
        Date premier;
        int filmId=Integer.parseInt(req.getParameter("filmId"));
        List<Actor> actors=new ArrayList<>();
        if(req.getParameter("filmName")!=null&&
                req.getParameter("dirSelector")!=null&&
                req.getParameter("comSelector")!=null&&
                req.getParameter("premier")!=null){
            premier=Date.valueOf(req.getParameter("premier"));
            DAO dao=DAOImpl.getInstance();
            FilmDAO filmDAO=new FilmDAOImpl(dao);
            DirectorDAO directorDao=new DirectorDAOImpl(dao);
            String dirId=req.getParameter("dirSelector");
            director=directorDao.getDirector(Integer.parseInt(dirId));
            CompanyDAO comDao=new CompanyDAOImpl(dao);
            company=comDao.getCompany(Integer.parseInt(req.getParameter("comSelector")));
            filmName=req.getParameter("filmName");
            Film film= new Film(filmId,director.getDirId(),premier,filmName,company.getComId());
            filmDAO.updateFilm(film);
            resp.sendRedirect("/filmList");
        }

    }
}
