package Com.ShowRoom.Bike;

import javax.management.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BikeDetails {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded Successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/bike_showroom";
        String userNAme = "root";
        String psw = "Chethan11chetu@g";
        String query = "insert into bike_details values('MT-15', '1234r8ity790876', '66687llt676', 250000, 35);";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userNAme, psw);
            statement = connection.createStatement();
            boolean ref = statement.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
