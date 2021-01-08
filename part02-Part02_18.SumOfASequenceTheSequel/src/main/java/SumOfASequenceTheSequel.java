
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        System.out.println("First number?");
        int firstNumber = scanner.nextInt();
        System.out.println("Last number?");
        int lastNumber = scanner.nextInt();
        for (int i = firstNumber; i <= lastNumber; i++) {
            sum = sum + i;
        }
        System.out.println("The sum is: " + sum);
    }
}
