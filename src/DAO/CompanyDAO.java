package DAO;

import model.Company;

import java.util.List;

/**
 * Created by пользователь on 18.03.2019.
 */
public interface CompanyDAO {
    String ID_COMPANY="id_company";
    String CO_NAME="co_name";
    void addCompany(Company company);
    List<Company> getCompanies();
    List<Company> getCompanies(String comName);
    Company getCompany(int companyId);
    void updateCompany(Company company);
    void deleteCompany(Company company);
    void deleteCompany(int companyId);

}
