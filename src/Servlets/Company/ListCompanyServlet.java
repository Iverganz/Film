package Servlets.Company;


import DAO.DAO;

import DAO.impl.CompanyDAOImpl;
import DAO.impl.DAOImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import DAO.CompanyDAO;
import model.Company;

/**
 * Created by пользователь on 23.03.2019.
 */
@WebServlet("/comList")
public class ListCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAOImpl.initInstance();
        DAO dao=DAOImpl.getInstance();
        dao.setURL(DAOImpl.DEFAULT_HOST, DAOImpl.DEFAULT_DATABASE, DAOImpl.DEFAULT_PORT);
        dao.connect(DAOImpl.DEFAULT_LOGIN, DAOImpl.DEFAULT_PASSWORD);
        CompanyDAO comDao=new CompanyDAOImpl(dao);
        List<Company> companies=comDao.getCompanies();
       // resp.setContentType("text/html;charset=UTF-8");
//        PrintWriter writer = resp.getWriter();
//        writer.println("<h2>"+"Hello world"+"</h2>");
//        writer.close();
        req.getSession().setAttribute("companies",companies);
        req.getRequestDispatcher("comList.jsp").forward(req,resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    public ListCompanyServlet(){}
}
