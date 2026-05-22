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

    public static void extraRuns2016() {

        String query = """
                SELECT d.bowling_team,
                       SUM(d.extra_runs) AS extra_runs
                FROM deliveries d
                JOIN matches m
                ON d.match_id = m.id
                WHERE m.season = 2016
                GROUP BY d.bowling_team
                ORDER BY extra_runs DESC;
                """;

        executeAndPrint(query);
    }

    public static void topEconomicalBowlers2015() {

        String query = """
                SELECT d.bowler,
                       ROUND(
                           SUM(d.total_runs) * 6.0
                           / COUNT(d.ball),
                           2
                       ) AS economy
                FROM deliveries d
                JOIN matches m
                ON d.match_id = m.id
                WHERE m.season = 2015
                GROUP BY d.bowler
                HAVING COUNT(d.ball) >= 60
                ORDER BY economy ASC
                LIMIT 10;
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