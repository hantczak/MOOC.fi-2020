
import java.util.Scanner;

public class Cubes {

    public static void main(String[] args) {
        String input;
        int integerConversion;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            input = scanner.nextLine();

            if (input.equals("end")){
                break;
            }
            integerConversion = Integer.valueOf(input);
            System.out.println(integerConversion*integerConversion*integerConversion);
        }
    }
}
