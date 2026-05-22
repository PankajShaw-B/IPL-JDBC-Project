import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class IPLService {

    public static void matchesPlayedPerYear() {

        String query = """
                SELECT season,
                       COUNT(*) AS total_matches
                FROM matches
                GROUP BY season
                ORDER BY season;
                """;

        executeAndPrint(query);
    }


    // 2. Matches won by all teams
    public static void matchesWonByTeams() {

        String query = """
                SELECT winner,
                       COUNT(*) AS wins
                FROM matches
                WHERE winner IS NOT NULL
                GROUP BY winner
                ORDER BY wins DESC;
                """;

        executeAndPrint(query);
    }

    public static void executeAndPrint(String query) {

        try (

                Connection connection = DBConnection.getConnection();

                Statement statement = connection.createStatement();

                ResultSet rs = statement.executeQuery(query)

        ) {

            int columns = rs.getMetaData().getColumnCount();

            while (rs.next()) {

                for (int i = 1; i <= columns; i++) {

                    System.out.print(rs.getString(i) + "   ");
                }

                System.out.println();
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}