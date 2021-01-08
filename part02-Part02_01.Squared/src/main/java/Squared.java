
import java.util.Scanner;

public class Squared {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.valueOf(scanner.nextLine());
        double square = Math.pow((double) input, 2.0);
        System.out.println(square);
    }
}
