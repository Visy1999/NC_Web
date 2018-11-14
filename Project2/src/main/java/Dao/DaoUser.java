package Dao;


import model.User;

import java.util.List;


public interface DaoUser {



    public void  addUser(User user);

    public void updateUser(User user);

    public void removeUser(int id);

    public User getUserId(int id);

    public List<User> listUser();


}
