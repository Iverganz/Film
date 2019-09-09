package Servlets.Director;

import DAO.ActorDao;
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
@WebServlet("/addDir")
public class AddDirectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("addDir.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //int actorId;
        String dirName;
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("dirName")!=null){
            //actorId=Integer.parseInt(request.getParameter("actorId"));
            dirName=request.getParameter("dirName");
            DAO.DirectorDAO directorDao= new DirectorDAOImpl(DAOImpl.getInstance());
            Director director=new Director(-1,dirName);
            directorDao.addDirector(director);
            response.sendRedirect("/dirList");
        }
    }
}
