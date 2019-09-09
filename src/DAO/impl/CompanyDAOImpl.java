package DAO.impl;

import DAO.CompanyDAO;
import DAO.DAO;
import model.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CompanyDAOImpl implements CompanyDAO {
    private DAO dao;

    public CompanyDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public void addCompany(Company company) {
        String query = "INSERT INTO company (id_company,co_name) VALUES (DEFAULT ,?);";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            //preparedStatement.setInt(1,company.getComId());
            preparedStatement.setString(1,company.getComName());
            preparedStatement.execute();
        }
        catch(SQLException e){e.printStackTrace();}
    }

    @Override
    public List<Company> getCompanies() {
        List<Company> companies=new ArrayList<>();
        String query ="SELECT * FROM company;";
        try (Connection connection = dao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                Company company=new Company(id,name);
                companies.add(company);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return companies;
    }

    @Override
    public List<Company> getCompanies(String comName) {
        return null;
    }

    @Override
    public Company getCompany(int companyId) {
        String query="SELECT * FROM company WHERE id_company= ?;";
        Company company=null;
        try(Connection connection=dao.getConnection()) {
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,companyId);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt(1);
                String name=resultSet.getString(2);
                company=new Company(id,name);
            }
        }
        catch (SQLException e){e.printStackTrace();}
        return company;
    }

    @Override
    public void updateCompany(Company company) {
        String query="UPDATE company SET co_name=? WHERE id_company=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(2,company.getComId());
            preparedStatement.setString(1,company.getComName());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void deleteCompany(Company company) {
        String query="DELETE FROM company WHERE id_company=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,company.getComId());
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }

    @Override
    public void deleteCompany(int companyId) {
        String query="DELETE FROM company WHERE id_company=?";
        try(Connection connection=dao.getConnection()){
            PreparedStatement preparedStatement=connection.prepareStatement(query);
            preparedStatement.setInt(1,companyId);
            preparedStatement.execute();
        }
        catch (SQLException e){e.printStackTrace();}
    }
}
