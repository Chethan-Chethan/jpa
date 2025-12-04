package Com.EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetails {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loadede successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Loaded successfully");
        }
        String url = "jdbc:mysql://@localhost:3306/employee_detailis";
        String userNAme = "root";
        String psw = "Chethan11chetu@g";
        String Query = "insert into emp_details values(23, \"SilkBoard\", 35000, 2, 'A');";

        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, userNAme, psw);
            System.out.println("Connection established successfully " + connection);

            statement = connection.createStatement();
            boolean ref = statement.execute(Query);
            System.out.println("Data inserted successfully " + ref);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Connection attempt finished");

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
