
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        String longestName;
        double yearAverage;
        String name;
        int yearsSum = 0;
        int i = 0;
        String[] firstRow;
        ArrayList<String[]> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(",");
            list.add(pieces);
            yearsSum = yearsSum + Integer.valueOf(pieces[1]);
            i++;
        }
        firstRow = list.get(0);
        longestName = firstRow[0];
        for (String[] row : list) {
            name = row[0];
            if (name.length() > longestName.length()) {
                longestName = name;
            }
        }
        System.out.println(yearsSum);
        yearAverage = (double) yearsSum / i;
        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + yearAverage);
    }
}