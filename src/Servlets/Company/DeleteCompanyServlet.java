package Servlets.Company;


import DAO.CompanyDAO;
import DAO.impl.CompanyDAOImpl;
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
@WebServlet("/deleteCom")
public class DeleteCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CompanyDAO comDao=new CompanyDAOImpl(DAOImpl.getInstance());
        if(req.getParameter("comId")!=null) {
            int actorId=Integer.parseInt(req.getParameter("comId"));
            comDao.deleteCompany(actorId);
        }
        resp.sendRedirect("comList");
    }
}
