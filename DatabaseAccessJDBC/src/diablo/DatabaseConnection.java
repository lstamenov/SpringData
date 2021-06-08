package diablo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnection {
    private Connection con;

    private void loadDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Driver not found");
        }
    }
    public Connection getCon(){
        loadDriver();
        loadDatabase();
        return con;
    }

    private void loadDatabase(){
        String username = "root";
        String password = "Stamenov1999?";
        try {
            Properties properties =new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            con =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306/diablo", properties);
            System.out.println("Connected to DB successfully");
        } catch (
                SQLException throwables) {
            System.err.println("Cannot connect to database");
            throwables.printStackTrace();
        }
    }
}
