
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class SportStatistics {

    public static void main(String[] args) {
        ArrayList<String[]> teamData;
        String filename;
        String chosenTeam;
        String homeTeam;
        String visitingTeam;
        int homeTeamPoints;
        int visitingTeamPoints;
        int gamesPlayed = 0;
        int chosenTeamWins = 0;
        int chosenTeamLosses = 0;
        System.out.println("File:");
        Scanner userInput = new Scanner(System.in);
        filename = userInput.nextLine();

        teamData = fileReader(filename);
        if (teamData != null) {

            System.out.println("Team:");
            chosenTeam = userInput.nextLine();

            for (String[] row : teamData) {
                homeTeam = row[0];
                visitingTeam = row[1];
                homeTeamPoints = Integer.valueOf(row[2]);
                visitingTeamPoints = Integer.valueOf(row[3]);


                if (chosenTeam.equals(homeTeam)) {
                    gamesPlayed++;
                    if (homeTeamPoints > visitingTeamPoints) {
                        chosenTeamWins++;
                    } else chosenTeamLosses++;


                } else if (chosenTeam.equals(visitingTeam)) {
                    gamesPlayed++;
                    if (visitingTeamPoints > homeTeamPoints) {
                        chosenTeamWins++;
                    } else chosenTeamLosses++;
                }
            }
            System.out.println("Games: " + gamesPlayed);
            System.out.println("Wins: " + chosenTeamWins);
            System.out.println("Losses: " + chosenTeamLosses);
        }
    }

    public static ArrayList<String[]> fileReader(String filename) {
        try (Scanner fileReader = new Scanner(Paths.get(filename));) {
            String row;
            String pieces[] = null;
            ArrayList<String[]> teamsData = new ArrayList<>();
            while (fileReader.hasNextLine()) {

                row = fileReader.nextLine();
                if (row.isEmpty()) {
                    continue;
                }
                pieces = row.split(",");
                teamsData.add(pieces);
            }
            return teamsData;
        } catch (Exception e) {
            System.out.println("File could not be read.");
            return null;
        }
    }
}