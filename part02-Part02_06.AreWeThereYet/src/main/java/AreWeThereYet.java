
import java.util.Scanner;

public class AreWeThereYet {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            System.out.println("Give a number:");
            number = scanner.nextInt();
        }while (number != 4);
    }
}
