package ua.ternopil.igorbendera.mapper;

import ua.ternopil.igorbendera.domain.Magazine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MagazineMapper {
    public static Magazine map(ResultSet result) throws SQLException {
        Integer magazineId = result.getInt("id");
        String photo = result.getString("photo");
        String name = result.getString("name");
        String description = result.getString("description");
        Double price = result.getDouble("price");

        return new Magazine(magazineId, photo, name, description, price);
    }
}
