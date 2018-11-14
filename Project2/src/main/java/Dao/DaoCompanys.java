package Dao;

import model.Company;


import java.util.List;


public interface DaoCompanys {

    public void addCompany(Company company);

    public void updatCompany(Company company);

    public void removeCompany(int id);

    public Company getCompanyId(int id);

    public List<Company> listCompany();

}
