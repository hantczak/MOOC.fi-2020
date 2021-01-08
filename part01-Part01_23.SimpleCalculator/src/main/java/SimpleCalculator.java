
import java.util.Scanner;

public class SimpleCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write your program here
        System.out.println("Give the first number:");
        int first = Integer.valueOf(scanner.nextLine());
        System.out.println("Give the second number:");
        int second = Integer.valueOf(scanner.nextLine());

        int sumResult = first + second;
        int differenceResult = first - second;
        int multiplicationResult = first * second;
        double quotientResult = (double) first / second;

        System.out.println(first + " + " + second + " = " + sumResult);
        System.out.println(first + " - " + second + " = " + differenceResult);
        System.out.println(first + " * " + second + " = " + multiplicationResult);
        System.out.println(first + " / " + second + " = " + quotientResult);


    }
}
