
import java.util.Random;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many random numbers should be printed?");
        Random random = new Random();
        int howMany = scanner.nextInt();
        printNumbers(howMany, random);

    }

    public static void printNumbers(int howMany, Random random) {
        for (int i = 0; i < howMany; i++) {
            System.out.println(random.nextInt(11));
        }
    }
}

