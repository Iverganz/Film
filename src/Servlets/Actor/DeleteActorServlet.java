package Servlets.Actor;

import DAO.ActorDao;
import DAO.impl.ActorDaoImpl;
import DAO.impl.DAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 23.03.2019.
 */
@WebServlet("/deleteActor")
public class DeleteActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ActorDao actorDao=new ActorDaoImpl(DAOImpl.getInstance());
        if(req.getParameter("actorId")!=null) {
            int actorId=Integer.parseInt(req.getParameter("actorId"));
            actorDao.deleteActor(actorId);
        }
        resp.sendRedirect("actorList");
    }
}
