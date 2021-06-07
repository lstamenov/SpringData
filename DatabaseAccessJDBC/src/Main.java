import java.sql.*;
import java.util.Objects;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection con = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Driver not found");
        }

        String username = "root";
        String password = "Stamenov1999?";
        try {
            Properties properties =new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/soft_uni", properties);
            System.out.println("Connected to DB successfully");
        } catch (SQLException throwables) {
            System.err.println("Cannot connect to database");
            throwables.printStackTrace();
        }

        assert con != null;
        printResult(filterEmployeesBySalary(40000, con));
    }
    public static ResultSet filterEmployeesBySalary(double salary, Connection con) throws SQLException {
        PreparedStatement preparedStatement = con.
                prepareStatement("SELECT CONCAT(first_name ,' ' , last_name) full_name FROM employees \n" +
                        "WHERE salary > ?");
        preparedStatement.setDouble(1, salary);
        return preparedStatement.executeQuery();
    }

    public static void printResult(ResultSet resultSet) throws SQLException {
        String name = "name";
        System.out.printf("| %-15s |%n ", name);
        while (resultSet.next()){
            System.out.printf("| %-15s |%n",
                     resultSet.getString("full_name"));
        }
    }
}
