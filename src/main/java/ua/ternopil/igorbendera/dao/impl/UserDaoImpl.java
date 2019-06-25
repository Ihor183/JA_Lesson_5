package ua.ternopil.igorbendera.dao.impl;

import ua.ternopil.igorbendera.dao.UserDao;
import ua.ternopil.igorbendera.domain.User;
import ua.ternopil.igorbendera.mapper.UserMapper;
import ua.ternopil.igorbendera.utils.DatabaseHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    private static String READ_ALL = "Select * from user where is_deleted=false";
    private static String CREATE = "Insert into user (email, password, first_name, last_name, role) values (?,?,?,?,?)";
    private static String READ_BY_ID = "Select * from user where id=? and is_deleted=false";
    private static String UPDATE_BY_ID = "Update user set email=?, password=?, first_name=?, " +
            "last_name=?, role=? where id=? and is_deleted=false";
    private static String DELETE_BY_ID = "Update user set is_deleted=true where id=? and is_deleted=false";
    private static String CHECK_USER = "Select * from user where email=? and password=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public UserDaoImpl() throws SQLException, ClassNotFoundException {
        connection = DatabaseHandler.getDbConnection();
    }

    @Override
    public User create(User user) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            getUserData(user, preparedStatement);
//            preparedStatement.setString(1, user.getEmail());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getFirstName());
//            preparedStatement.setString(4, user.getLastName());
//            preparedStatement.setString(5, user.getRole());

//            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();
            result.next();
            user.setId(result.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User read(Integer id) {
        User user = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            user = UserMapper.map(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User update(User user) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            getUserData(user, preparedStatement);
//            preparedStatement.setString(1, user.getEmail());
//            preparedStatement.setString(2, user.getPassword());
//            preparedStatement.setString(3, user.getFirstName());
//            preparedStatement.setString(4, user.getLastName());
//            preparedStatement.setString(5, user.getRole());
//            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void delete(Integer id) {
        try {
            preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean isUserExist(User user) {
        try {
            preparedStatement = connection.prepareStatement(CHECK_USER);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            ResultSet result = preparedStatement.executeQuery();

            if(result.next()) {
                user.setId(result.getInt("id"));
                user.setFirstName(result.getString("first_name"));
                user.setLastName(result.getString("last_name"));
                user.setRole(result.getString("role"));

                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void getUserData(User user, PreparedStatement preparedStatement) throws SQLException{
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setString(3, user.getFirstName());
        preparedStatement.setString(4, user.getLastName());
        preparedStatement.setString(5, user.getRole());

        preparedStatement.executeUpdate();
    }

    @Override
    public List<User> readAll() {
        List<User> users = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                users.add(UserMapper.map(result));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return users;
    }
}
