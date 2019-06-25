package ua.ternopil.igorbendera.dao.impl;

import ua.ternopil.igorbendera.dao.SubscribeDao;
import ua.ternopil.igorbendera.domain.Subscribe;
import ua.ternopil.igorbendera.mapper.SubscribeMapper;
import ua.ternopil.igorbendera.utils.DatabaseHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribeDaoImpl implements SubscribeDao {
    private static String READ_ALL = "Select * from subscribe";
    private static String CREATE = "Insert into subscribe (user_id, magazine_id) values (?,?)";
    private static String READ_BY_ID = "Select * from subscribe where id=?";
    private static String DELETE_BY_ID = "Delete from subscribe where id=?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public SubscribeDaoImpl() throws SQLException, ClassNotFoundException {
        connection = DatabaseHandler.getDbConnection();
    }

    @Override
    public Subscribe create(Subscribe subscribe) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, subscribe.getUserId());
            preparedStatement.setInt(2, subscribe.getMagazineId());

            preparedStatement.executeUpdate();

            ResultSet result = preparedStatement.getGeneratedKeys();
            result.next();
            subscribe.setId(result.getInt(1));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribe;
    }

    @Override
    public Subscribe read(Integer id) {
        Subscribe subscribe = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            subscribe = SubscribeMapper.map(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return subscribe;
    }

    @Override
    public Subscribe update(Subscribe subscribe) {
        throw new IllegalStateException("there is no update for subscribe");
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

    @Override
    public List<Subscribe> readAll() {
        List<Subscribe> subscribes = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()) {
                subscribes.add(SubscribeMapper.map(result));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return subscribes;
    }
}
