public class Main {

    public static void main(String[] args) {

        System.out.println(
                "IPL JDBC PROJECT"
        );

        System.out.println(
                "\n1. Matches Played Per Year"
        );

        IPLService.matchesPlayedPerYear();

        System.out.println(
                "\n2. Matches Won By Teams"
        );

        IPLService.matchesWonByTeams();
    }
}