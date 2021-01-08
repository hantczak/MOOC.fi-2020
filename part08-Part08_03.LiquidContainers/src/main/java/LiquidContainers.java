
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstContainer = 0;
        int secondContainer = 0;


        while (true) {
            //System.out.print("> ");
            System.out.println("First: " + firstContainer + "/100");
            System.out.println("Second: " + secondContainer + "/100");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] inputParts = input.split(" ");

            if (inputParts[0].equals("add")) {
                if (Integer.valueOf(inputParts[1]) < 0) {
                    continue;
                }
                if (firstContainer + Integer.valueOf(inputParts[1]) >= 100) {
                    firstContainer = 100;
                } else {
                    firstContainer += Integer.valueOf(inputParts[1]);
                }
            }
            if (inputParts[0].equals("move")) {
                if (Integer.valueOf(inputParts[1]) > firstContainer) {
                    if (firstContainer + secondContainer > 100) {
                        secondContainer = 100;
                        firstContainer = 0;
                    } else {
                        secondContainer += firstContainer;
                        firstContainer = 0;
                    }
                } else {
                    if (secondContainer + Integer.valueOf(inputParts[1]) > 100) {
                        firstContainer = firstContainer - Integer.valueOf(inputParts[1]);
                        secondContainer = 100;
                    } else {
                        secondContainer += Integer.valueOf(inputParts[1]);
                        firstContainer = firstContainer - Integer.valueOf(inputParts[1]);
                    }
                }
            }
            if (inputParts[0].equals("remove")) {
                if (secondContainer < Integer.valueOf(inputParts[1])) {
                    secondContainer = 0;
                } else {
                    secondContainer = secondContainer - Integer.valueOf(inputParts[1]);
                }
            }

        }
    }
}
