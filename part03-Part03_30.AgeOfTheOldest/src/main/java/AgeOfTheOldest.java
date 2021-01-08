
import java.util.Scanner;

public class AgeOfTheOldest {

    public static void main(String[] args) {
        int highestAge = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(",");
            if (Integer.valueOf(pieces[1]) > highestAge) {
                highestAge = Integer.valueOf(pieces[1]);
            }
        }
        System.out.println("Age of the oldest: " + highestAge);
    }
}
