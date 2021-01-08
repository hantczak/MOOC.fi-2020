
import java.util.Scanner;

public class SquareRootOfSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int sum = first + second;
        double squareRoot = Math.sqrt((double) sum);
        System.out.println((int)squareRoot);
    }
}
