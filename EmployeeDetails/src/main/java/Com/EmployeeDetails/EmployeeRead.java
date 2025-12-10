package Com.EmployeeDetails;

import java.sql.*;

public class EmployeeRead {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_detailis", "root", "Chethan11chetu@g");
            preparedStatement = connection.prepareStatement("select * from emp_details");
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null) {
                System.out.println("Connection established successfully " + resultSet);
                while (resultSet.next()) {
                    System.out.println("Connection established successfully");
                    System.out.println("Emp id " + resultSet.getInt("emp_id"));
                    System.out.println("Emp Address " + resultSet.getString("emp_address"));
                    System.out.println("Emp Salary " + resultSet.getInt("emp_salary"));
                    System.out.println("Emp Experience " + resultSet.getInt("emp_experience"));
                    System.out.println("--------------------------------------------------------------------");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
