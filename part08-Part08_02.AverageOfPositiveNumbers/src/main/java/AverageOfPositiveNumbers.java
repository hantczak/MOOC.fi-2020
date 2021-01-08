
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        int sum = 0;
        double average = 0;

        while (true) {
            int input = Integer.valueOf(scanner.nextLine());

            if (input == 0) {
                break;
            }

            if (input > 0) {
                sum += input;
                i++;
            }
        }
        if (sum == 0) {
            System.out.println("Cannot calculate the average");
        } else {
            average = sum*1.0 / i;
            System.out.println(average);
        }
    }
}
