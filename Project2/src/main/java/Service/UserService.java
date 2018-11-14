package Service;

import ConSQL.Connect;
import Dao.DaoUser;
import model.User;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserService implements DaoUser {

    private Connection connection = null;

    @Override
    public  void addUser(User user) {
        try {


            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO users(idusers,name,idcompany,check)" +
                                                 " VALUES(?,?,?,?) ");

            preparedStatement.setInt(1, user.getIdusers());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setInt(3, user.getIdcompany());
            preparedStatement.setInt(4, user.getCheck());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("Can'not Connection with SQL");
        }



    }

    @Override
    public void updateUser(User user) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("update users set name=?, idcompany=?, check=? where idusers=?");


            preparedStatement.setString(1, user.getName());
            preparedStatement.setInt(2, user.getIdcompany());
            preparedStatement.setInt(3, user.getCheck());
            preparedStatement.setInt(4, user.getIdusers());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void removeUser(int id) {

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("delete from users  where idusers=?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<User> listUser() {
        List<User> users = new ArrayList<User>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from users");
            while (rs.next()) {
                User user = new User();
                user.setIdusers(rs.getInt("idusers"));
                user.setName(rs.getString("name"));
                user.setIdcompany(rs.getInt("idcompany"));
                user.setCheck(rs.getInt("check"));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return  users;
    }

    public User getUserId(int id)
    {
        User user = new User();
        try{

            PreparedStatement preparedStatement = connection.
                    prepareStatement("select * from users where idusers=?");
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){

                user.setIdusers(rs.getInt("idusers"));
                user.setName(rs.getString("name"));
                user.setIdcompany(rs.getInt("idcompany"));
                user.setCheck(rs.getInt("check"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
       return user;
    }

    public UserService()
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
