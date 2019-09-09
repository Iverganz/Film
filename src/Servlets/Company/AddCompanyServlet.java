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
@WebServlet("/addCom")
public class AddCompanyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("addCom.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String comName;
        request.setCharacterEncoding("UTF-8");
        if(request.getParameter("comName")!=null){

            comName=request.getParameter("comName");
            CompanyDAO comDao= new CompanyDAOImpl(DAOImpl.getInstance());
            Company company=new Company(-1,new String( comName.getBytes("UTF-8"),"UTF-8"));
            comDao.addCompany(company);
            response.sendRedirect("/comList");
        }
    }
}
