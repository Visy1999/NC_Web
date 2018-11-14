package model;

import javax.persistence.*;


public class Company {


    private int idcompanys;

    private String name;

    private String employee;

    public int getIdcompanys() {
        return idcompanys;
    }

    public void setIdcompanys(int idcompanys) {
        this.idcompanys = idcompanys;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }


}
