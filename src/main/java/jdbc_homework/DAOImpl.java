package jdbc_homework;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOImpl {

    public int insertAccomodation(Accomodation accomodation) {
        try (Connection connection = getConnection()) {
            String sqlString = "INSERT INTO accomodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, accomodation.getId());
            preparedStatement.setString(2, accomodation.getType());
            preparedStatement.setString(3, accomodation.getBedType());
            preparedStatement.setInt(4, accomodation.getMaxGuests());
            preparedStatement.setString(5, accomodation.getDescription());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insertRoomFair(RoomFair roomFair) {
        try (Connection connection = getConnection()) {
            String sqlString = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, roomFair.getId());
            preparedStatement.setDouble(2, roomFair.getValue());
            preparedStatement.setString(3, roomFair.getSeason());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int insertAccomodationFair(AccomodationFair accomodationFair) {
        try (Connection connection = getConnection()) {
            String sqlString = "INSERT INTO accomodation_fair_relation (id, id_accomodation, id_room_fair) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            preparedStatement.setInt(1, accomodationFair.getId());
            preparedStatement.setInt(2, accomodationFair.getIdAccomodation());
            preparedStatement.setInt(3, accomodationFair.getIdRoomFair());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<AccomodationPrices> getPricesPerEachRoom() {
        List<AccomodationPrices> accomodationPrices= new ArrayList<>();
        try (Connection connection = getConnection()) {
            String sqlString = "SELECT accomodation_fair_relation.id, accomodation_fair_relation.id_accomodation, accomodation_fair_relation.id_room_fair,\n" +
                    "                    accomodation.type, accomodation.bed_type, room_fair.value, room_fair.season\n" +
                    "                    FROM accomodation_fair_relation\n" +
                    "                    INNER JOIN accomodation ON accomodation_fair_relation.id_accomodation = accomodation.id\n" +
                    "                    INNER JOIN room_fair ON accomodation_fair_relation.id_room_fair = room_fair.id";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlString);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                AccomodationPrices accomodationPrice = new AccomodationPrices();
                accomodationPrice.setId(rs.getInt("id"));
                accomodationPrice.setIdAccomodation(rs.getInt("id_accomodation"));
                accomodationPrice.setIdRoomFair(rs.getInt("id_room_fair"));
                accomodationPrice.setAccomodationType(rs.getString("type"));
                accomodationPrice.setBedType(rs.getString("bed_type"));
                accomodationPrice.setValue(rs.getDouble("value"));
                accomodationPrice.setSeason(rs.getString("season"));
                accomodationPrices.add(accomodationPrice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accomodationPrices;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/jdbcdb", "postgres", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
