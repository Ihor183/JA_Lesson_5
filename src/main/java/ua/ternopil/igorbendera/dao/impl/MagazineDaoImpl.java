package ua.ternopil.igorbendera.dao.impl;

import ua.ternopil.igorbendera.dao.MagazineDao;
import ua.ternopil.igorbendera.domain.Magazine;
import ua.ternopil.igorbendera.mapper.MagazineMapper;
import ua.ternopil.igorbendera.utils.DatabaseHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MagazineDaoImpl implements MagazineDao {
    private static String READ_ALL = "Select * from magazine where is_deleted=false";
    private static String CREATE = "Insert into magazine (photo, name, description, price) values (?,?,?,?)";
    private static String READ_BY_ID = "Select * from magazine where id=? and is_deleted=false";
    private static String UPDATE_BY_ID = "Update magazine set photo=?, name=?, description=?, price=?  " +
            "where id=? and is_deleted=false";
    private static String DELETE_BY_ID = "Update magazine set is_deleted=true where id=? and is_deleted=false";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public MagazineDaoImpl() throws SQLException, ClassNotFoundException {
        connection = DatabaseHandler.getDbConnection();
    }

    @Override
    public Magazine create(Magazine magazine) {
        try {
            preparedStatement = connection.prepareStatement(CREATE, Statement.RETURN_GENERATED_KEYS);
            getMagazineData(magazine, preparedStatement);

            ResultSet result = preparedStatement.getGeneratedKeys();
            result.next();
            magazine.setId(result.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazine;
    }

    @Override
    public Magazine read(Integer id) {
        Magazine magazine = null;
        try {
            preparedStatement = connection.prepareStatement(READ_BY_ID);
            ResultSet result = preparedStatement.executeQuery();

            result.next();
            magazine = MagazineMapper.map(result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return magazine;
    }

    @Override
    public Magazine update(Magazine magazine) {
        try {
            preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
            getMagazineData(magazine, preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return magazine;
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

    public void getMagazineData(Magazine magazine, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, magazine.getPhoto());
        preparedStatement.setString(2, magazine.getName());
        preparedStatement.setString(3, magazine.getDescription());
        preparedStatement.setDouble(4, magazine.getPrice());
        preparedStatement.executeUpdate();
    }

    @Override
    public List<Magazine> readAll() {
        List<Magazine> magazine = new ArrayList<>();

        try {
            preparedStatement = connection.prepareStatement(READ_ALL);
            ResultSet result = preparedStatement.executeQuery();

            while (result.next()){
                magazine.add(MagazineMapper.map(result));
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return magazine;
    }
}
