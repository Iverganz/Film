package Servlets.Actor;

import DAO.impl.ActorDaoImpl;
import DAO.impl.DAOImpl;
import DAO.DAO;
import DAO.ActorDao;
import model.Actor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by пользователь on 23.03.2019.
 */
//@WebServlet("/actorList")
public class ListActorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOImpl.initInstance();
        DAO dao=DAOImpl.getInstance();
        dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
        dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
        ActorDao actorDao=new ActorDaoImpl(dao);
        List<Actor> actors=actorDao.getActors();
       // resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h2>"+"Hello world"+"</h2>");
//        writer.close();
        req.getSession().setAttribute("actors",actors);
        req.getRequestDispatcher("actorList.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    public ListActorServlet(){}
}
