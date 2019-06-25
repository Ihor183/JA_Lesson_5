package ua.ternopil.igorbendera.service.impl;

import ua.ternopil.igorbendera.dao.UserDao;
import ua.ternopil.igorbendera.dao.impl.UserDaoImpl;
import ua.ternopil.igorbendera.domain.User;
import ua.ternopil.igorbendera.service.UserService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
//    private List<User> users = new ArrayList<>();
//    private static UserService userService;

    public UserServiceImpl() {
        try {
            userDao = new UserDaoImpl();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//    public static UserService getUserService() {
//        if(userService == null) {
//            userService = new UserService();
//        }
//        return userService;
//    }

    @Override
    public User create(User user) {
        return userDao.create(user);
    }

    @Override
    public User read(Integer id) {
        return userDao.read(id);
    }

    @Override
    public User update(User user) {
        return userDao.update(user);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

//    public boolean isUserExist(User user) {
//        return userDao.
//    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }
}

//package ua.ternopil.igorbendera.service;
//
//        import ua.ternopil.igorbendera.domain.User;
//
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class UserService {
//    private List<User> users = new ArrayList<>();
//    private static UserService userService;
//
//    private UserService() { }
//
//    public static UserService getUserService() {
//        if(userService == null) {
//            userService = new UserService();
//        }
//        return userService;
//    }
//
//    public List<User> getUsers() {
//        return users;
//    }
//
//    public void saveUser(User user) {
//        users.add(user);
//    }
//
//    public User getParticularUser(String email) {
//        return users.stream().filter(user -> user.getEmail().equals(email)).findAny().orElse(null);
//    }
//}
