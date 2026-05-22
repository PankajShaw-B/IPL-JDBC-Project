import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/ipl";

    private static final String USER =
            "postgres";

    private static final String PASSWORD =
            "postgres123";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            Class.forName(
                    "org.postgresql.Driver"
            );

            connection =
                    DriverManager.getConnection(
                            URL,
                            USER,
                            PASSWORD
                    );

            System.out.println(
                    "Database Connected!"
            );

        } catch (Exception e) {

            e.printStackTrace();
        }

        return connection;
    }
}