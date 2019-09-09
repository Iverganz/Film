package Servlets.Film;

import DAO.DAO;
import DAO.DirectorDAO;
import DAO.impl.CompanyDAOImpl;
import DAO.impl.DAOImpl;
import DAO.impl.DirectorDAOImpl;
import DAO.impl.FilmDAOImpl;
import model.Actor;
import model.Company;
import model.Director;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import DAO.CompanyDAO;
import model.Film;
import DAO.FilmDAO;
/**
 * Created by пользователь on 08.04.2019.
 */
@WebServlet("/addFilm")
public class AddFilmServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOImpl.initInstance();
        DAO dao=DAOImpl.getInstance();
        dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
        dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
        DirectorDAO directorDao=new DirectorDAOImpl(dao);
        List<Director> directors=directorDao.getDirectors();
        request.setAttribute("directors",directors);
        CompanyDAO companyDAO=new CompanyDAOImpl(dao);
        List<Company> companies=companyDAO.getCompanies();
        request.setAttribute("companies",companies);
        request.getRequestDispatcher("addFilm.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Director director;
        Company company;
        String filmName;
        Date premier;
        req.setCharacterEncoding("UTF-8");
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
            Film film= new Film(-1,director.getDirId(),premier,filmName,company.getComId());
            filmDAO.addFilm(film);
            resp.sendRedirect("/filmList");
        }

    }
}
