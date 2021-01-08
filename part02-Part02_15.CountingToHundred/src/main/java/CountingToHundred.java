
import java.util.Scanner;

public class CountingToHundred {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int i;
        for (i = number; i <= 100; i++) {
            System.out.println(i);

        }
    }
}
