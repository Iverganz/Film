package Servlets.Company;


import DAO.CompanyDAO;
import DAO.impl.CompanyDAOImpl;
import DAO.impl.DAOImpl;
import model.Company;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by пользователь on 23.03.2019.
 */
@WebServlet("/editCom")
public class UpdCompanyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Company company=null;
        CompanyDAO comDao=new CompanyDAOImpl(DAOImpl.getInstance());
        if(req.getParameter("comId")!=null){
        int comId=Integer.parseInt(req.getParameter("comId"));
        company=comDao.getCompany(comId);
        }
        req.getSession().setAttribute("comToEdit",company);
        req.getRequestDispatcher("editCom.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String comName;
        req.setCharacterEncoding("UTF-8");
        int comId=Integer.parseInt(req.getParameter("comId"));
        comName=req.getParameter("comName");
        if(req.getParameter("comId")!=null&&req.getParameter("comName")!=null){
            CompanyDAO comDao=new CompanyDAOImpl(DAOImpl.getInstance());
            comName=req.getParameter("comName");

            Company company=(Company) req.getSession().getAttribute("comToEdit");
            company.setComName(comName);
            comDao.updateCompany(company);
            resp.sendRedirect("comList");
        }
    }
}
