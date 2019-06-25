package ua.ternopil.igorbendera.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    private static String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName + "?serverTimezone=UTC";

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException  {
        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(connectionString, dbUser, dbPass);
    }
}
