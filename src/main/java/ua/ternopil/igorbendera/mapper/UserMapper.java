package ua.ternopil.igorbendera.mapper;

import ua.ternopil.igorbendera.domain.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {

    public static User map(ResultSet result) throws SQLException {
        Integer userId = result.getInt("id");
        String email = result.getString("email");
        String password = result.getString("password");
        String firstName = result.getString("first_name");
        String lastName = result.getString("last_name");
        String role = result.getString("role");

        return new User(userId, email, password, firstName, lastName, role);
    }
}
