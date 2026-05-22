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

        System.out.println(
                "\n3. Extra Runs Conceded in 2016"
        );

        IPLService.extraRuns2016();

        System.out.println(
                "\n4. Top Economical Bowlers 2015"
        );

        IPLService.topEconomicalBowlers2015();
    }
}