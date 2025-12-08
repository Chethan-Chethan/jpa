package Com.EmployeeDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeUpdate {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String updateQuery = "update emp_details set emp_salary = ? where emp_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_detailis", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setInt(1, 45000);
            preparedStatement.setInt(2, 18);
            int rows = preparedStatement.executeUpdate();
            System.out.println("rows updated " + rows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
