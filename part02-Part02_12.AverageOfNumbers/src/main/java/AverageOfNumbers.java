
import java.util.Scanner;

public class AverageOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int i = 0;
        double average = 0;
        while (true) {
            System.out.println("Give a number:");
            int number = scanner.nextInt();

            if (number == 0) {
                break;
            }
            i++;
            sum = sum + number;
        }
        average = (double)sum/i;
        System.out.println("Average of the numbers: " + average);
    }
}
