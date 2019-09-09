package Servlets.Director;

import DAO.ActorDao;
import DAO.DirectorDAO;
import DAO.impl.ActorDaoImpl;
import DAO.impl.DAOImpl;
import DAO.impl.DirectorDAOImpl;
import model.Actor;
import model.Director;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 23.03.2019.
 */
@WebServlet("/editDir")
public class UpdDirectorServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Director director=null;
        DirectorDAO directorDAO=new DirectorDAOImpl(DAOImpl.getInstance());
        int dirId;
        if(req.getParameter("dirId")!=null){
        dirId=Integer.parseInt(req.getParameter("dirId"));
        director=directorDAO.getDirector(dirId);
        }
        req.getSession().setAttribute("dirToEdit",director);
        req.getRequestDispatcher("editDir.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String dirName;
        req.setCharacterEncoding("UTF-8");
        if(req.getParameter("dirId")!=null&&req.getParameter("dirName")!=null){
            DirectorDAO dirDao=new DirectorDAOImpl(DAOImpl.getInstance());
            dirName=req.getParameter("dirName");
            //actorId=req.getParameter("actorId");
            Director director=(Director) req.getSession().getAttribute("dirToEdit");
            director.setDirName(dirName);
            dirDao.updateDirector(director);
            resp.sendRedirect("dirList");
        }
    }
}
