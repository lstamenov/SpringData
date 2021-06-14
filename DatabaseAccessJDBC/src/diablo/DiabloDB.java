package diablo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class DiabloDB {
    public static void main(String[] args) throws SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        DBMethods methods = new DBMethods(new DatabaseConnection().getCon());
        methods.getUserByName("ebacha");
    }
}
