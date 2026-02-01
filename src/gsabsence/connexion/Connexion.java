package gsabsence.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {

    private static final String LOGIN = "root";
    private static final String PASSWORD = "";
    private static final String URL
                = "jdbc:mysql://localhost:3306/gsabsence?useSSL=false&serverTimezone=UTC";

    private static Connection connection = null;

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");

                connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
                System.out.println("✅ Database connected");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC Driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Database connection failed");
            e.printStackTrace();
        }

        return connection;
    }

    // TEST
    public static void main(String[] args) {
        if (getConnection() != null) {
            System.out.println("Connection OK");
        } else {
            System.out.println("Connection FAILED");
        }
    }
}
