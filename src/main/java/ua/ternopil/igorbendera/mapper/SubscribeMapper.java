package ua.ternopil.igorbendera.mapper;

import ua.ternopil.igorbendera.domain.Subscribe;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscribeMapper {
    public static Subscribe map(ResultSet result) throws SQLException {
        Integer subscribeId = result.getInt("id");
        Integer userId = result.getInt("user_id");
        Integer magazineId = result.getInt("magazine_id");
        Date purchaseDate = result.getDate("purchase_date");

        return new Subscribe(subscribeId, userId, magazineId, purchaseDate);
    }
}
