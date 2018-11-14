package Service;

import ConSQL.Connect;
import Dao.DaoCompanys;
import model.Company;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CompanyService implements DaoCompanys {
    private Connection connection = null;

    @Override
    public  void addCompany(Company company) {
        try {


            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO companys(idcompanys,name,employee) " +
                            " VALUES(?,?,?) ");


            preparedStatement.setInt(1, company.getIdcompanys());
            preparedStatement.setString(2, company.getName());
            preparedStatement.setString(3, company.getEmployee());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Can'not Connection with SQL");
        }



    }

    @Override
    public void updatCompany(Company company) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update companys set name=?, employee=? where idcompanys=?");


            preparedStatement.setString(1, company.getName());
            preparedStatement.setString(2, company.getEmployee());
            preparedStatement.setInt(3, company.getIdcompanys());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void removeCompany(int id) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from companys where idcompanys=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Company> listCompany() {
        List<Company> companys = new ArrayList<Company>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from companys");
            while (rs.next()) {
                Company company = new Company();
                company.setIdcompanys(rs.getInt("idcompanys"));
                company.setName(rs.getString("name"));
                company.setEmployee(rs.getString("employee"));
                companys.add(company);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  companys;
    }

    public Company getCompanyId(int id)
    {
        Company  company = new Company();
        try{

            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from companys where idcompanys=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){

                company.setIdcompanys(rs.getInt("idcompanys"));
                company.setName(rs.getString("name"));
                company.setEmployee(rs.getString("employee"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }

    public CompanyService()
    {
        try {
            connection = Connect.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }










}
