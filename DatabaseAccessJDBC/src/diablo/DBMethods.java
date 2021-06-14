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

    public void getAllUsersAndGamesPlayed() throws SQLException {
        PreparedStatement ps =
                con.prepareStatement("SELECT u.user_name, CONCAT(u.first_name, ' ', u.last_name)\n" +
                        "    AS full_name, COUNT(ug.id) AS games_played FROM users AS u\n" +
                        "JOIN users_games ug on u.id = ug.user_id\n" +
                        "GROUP BY full_name, user_name\n" +
                        "ORDER BY games_played DESC");
        ResultSet set = ps.executeQuery();
        while (set.next()){
            System.out.printf("| %-20s | %-25s | %d |%n",
            set.getString("user_name"), set.getString("full_name")
            , set.getInt( "games_played"));
        }
    }

    public void addUser(String username, String firstName,
                        String lastName, String email, String ipAddress) throws SQLException {
        if (username.trim().length() > 0 && ipAddress.trim().length() > 0){
            PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO users " +
                            "  (user_name, first_name, last_name, email, ip_address) " +
                            "  VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, username);
            statement.setString(2, firstName);
            statement.setString(3, lastName);
            statement.setString(4, email);
            statement.setString(5, ipAddress);
            statement.executeUpdate();
            System.out.println("Added user successfully!");
        }else {
            System.out.println("Adding user failed... Invalid data");
        }
    }

    public void deleteUserByUsername(String username) throws SQLException {
        PreparedStatement deleteStatement =
                con.prepareStatement("DELETE FROM users " +
                        "WHERE user_name LIKE ?");
        deleteStatement.setString(1, username);
        deleteStatement.executeUpdate();
        System.out.printf("Deleted user '%s' successfully!", username);
    }
}
