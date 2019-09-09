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
@WebServlet("/editActor")
public class UpdActorServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Actor actor=null;
        ActorDao ActorDao=new ActorDaoImpl(DAOImpl.getInstance());
        if(req.getParameter("actorId")!=null){
        int actorId=Integer.parseInt(req.getParameter("actorId"));
        actor=ActorDao.getActor(actorId);
        }
        req.getSession().setAttribute("actorToEdit",actor);
        req.getRequestDispatcher("editActor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actorName;
        req.setCharacterEncoding("UTF-8");
        int actorId=Integer.parseInt(req.getParameter("actorId"));
        actorName=req.getParameter("actorName");
        if(req.getParameter("actorId")!=null&&req.getParameter("actorName")!=null){
            ActorDao actorDao=new ActorDaoImpl(DAOImpl.getInstance());
            actorName=req.getParameter("actorName");
            //actorId=req.getParameter("actorId");
            Actor actor=(Actor) req.getSession().getAttribute("actorToEdit");
            actor.setActorName(actorName);
            actorDao.updateActor(actor);
            resp.sendRedirect("actorList");
        }
    }
}
