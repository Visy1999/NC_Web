package model;


import javax.persistence.*;


public class User {

    private int idusers;

    private String name;

    private int idcompany;

    private int check;

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {this.check = check;}

    public int getIdusers() {
        return idusers;
    }

    public void setIdusers(int idusers) {
        this.idusers = idusers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdcompany() {
        return idcompany;
    }

    public void setIdcompany(int idcompany) {
        this.idcompany = idcompany;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + idusers +
                ", Name='" + name + '\'' +
                ", idcompany='" + idcompany + '\'' +
                '}';
    }



}
