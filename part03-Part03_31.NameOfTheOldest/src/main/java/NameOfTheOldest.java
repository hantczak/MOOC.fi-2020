
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        int highestAge=0;
        String oldestPerson = "default";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }
            String[] pieces = input.split(",");
            if (Integer.valueOf(pieces[1])>highestAge){
                highestAge = Integer.valueOf(pieces[1]);
                oldestPerson = pieces[0];
            }
        }
        System.out.println("Name of the oldest: " + oldestPerson);
    }
}