
import java.util.Scanner;

public class Factorial {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int factorial = 1;
        System.out.println("Give a number:");
        int number = scanner.nextInt();
        if (number != 0) {
            for (int i = 1; i <= number; i++) {

                factorial = factorial * i;
            }
        }else {
            factorial=1;
        }
        System.out.println("Factorial: " + factorial);
    }
}