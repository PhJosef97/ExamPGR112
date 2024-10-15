package ManageSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseSystemConnection {
    private static final String CONNECTION_URL_UNIVERSITY = "jdbc:mysql://localhost:3306/universityDB";
    private static final String CONNECTION_URL_EVENT = "jdbc:mysql://localhost:3306/eventDB";

    public Connection getUniversityConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_URL_UNIVERSITY, "examPGR112", "PGR112");
        } catch (SQLException e) {
            System.out.println("Failed to create the database connection for universityDB.");
            e.printStackTrace();
        }
        return connection;
    }

    public Connection getEventConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_URL_EVENT, "examPGR112", "PGR112");
        } catch (SQLException e) {
            System.out.println("Failed to create the database connection for eventDB.");
            e.printStackTrace();
        }
        return connection;
    }
}

