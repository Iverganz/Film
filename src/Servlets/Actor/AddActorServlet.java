package Servlets.Actor;

import DAO.ActorDao;
import DAO.impl.ActorDaoImpl;
import DAO.impl.DAOImpl;
import model.Actor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 23.03.2019.
 */
//@WebServlet("/addActor")
public class AddActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("addActor.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //int actorId;
        String actName;
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("actName")!=null){
            //actorId=Integer.parseInt(request.getParameter("actorId"));
            actName=request.getParameter("actName");
            ActorDao actorDao= new ActorDaoImpl(DAOImpl.getInstance());
            Actor actor=new Actor(-1,new String( actName.getBytes("UTF-8"),"UTF-8"));
            actorDao.addActor(actor);
            response.sendRedirect("/actorList");
        }
    }
}
