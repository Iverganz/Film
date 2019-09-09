package Servlets.Director;

import DAO.ActorDao;
import DAO.DirectorDAO;
import DAO.impl.ActorDaoImpl;
import DAO.impl.DAOImpl;
import DAO.impl.DirectorDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 23.03.2019.
 */
@WebServlet("/deleteDir")
public class DeleteDirectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DirectorDAO dirDao=new DirectorDAOImpl(DAOImpl.getInstance());
        if(req.getParameter("dirId")!=null) {
            int dirId=Integer.parseInt(req.getParameter("dirId"));
            dirDao.deleteDirector(dirId);
        }
        resp.sendRedirect("dirList");
    }
}
