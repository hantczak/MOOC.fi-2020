
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne
        List<String> list = new ArrayList<>();
        while (true) {
            String row = scanner.nextLine();
            if (row.equals("end")) {
                break;
            }
            list.add(row);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String userInput = scanner.nextLine();
        if (userInput.equals("n")) {
            double average = list.stream()
                    .mapToInt(s -> Integer.valueOf(s))
                    .filter(number -> number<0)
                    .average()
                    .getAsDouble();
            System.out.println("Average of the negative numbers: " + average);
        }else if(userInput.equals("p")){
            double average = list.stream()
                        .mapToInt(s -> Integer.valueOf(s))
                        .filter(number -> number>0)
                        .average()
                        .getAsDouble();
            System.out.println("Average of the positive numbers: " + average);
        }


    }
}
