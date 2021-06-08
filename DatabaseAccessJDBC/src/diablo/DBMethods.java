package diablo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMethods {
    private Connection con;

    DBMethods(Connection con){
        this.con = con;
    }

    public void getAllCharacters(){
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM characters");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                System.out.printf("| %d | %-15s |%n",
                        resultSet.getInt("id"), resultSet.getString("name"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getUserByName(String username) throws SQLException {
        PreparedStatement ps =
                con.prepareStatement("SELECT CONCAT(u.first_name, ' ', u.last_name) full_name, COUNT(ug.id) games_played " +
                        "FROM users AS u " +
                        "JOIN users_games ug on u.id = ug.user_id " +
                        "WHERE u.user_name LIKE ? " +
                        "GROUP BY full_name");
        ps.setString(1, username);
        ResultSet resultSet = ps.executeQuery();
        boolean isSuchUser = false;
            while (resultSet.next()){
                isSuchUser = true;
                System.out.printf("User: %s%n", resultSet.getString("full_name"));
                System.out.printf("%s has played %d games",resultSet.getString("full_name") ,resultSet.getInt("games_played"));
            }
            if (!isSuchUser){
                System.out.println("No such user exists");
            }
    }
}
