
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Container firstContainer = new Container();
        Container secondContainer = new Container();

        while (true) {
            // System.out.print("> ");

            System.out.println("First: " +  firstContainer);
            System.out.println("Second: " + secondContainer);
            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }
            String[] pieces = input.split(" ");

            if (pieces[0].equals("add")) {
                firstContainer.add(Integer.valueOf(pieces[1]));
            }

            if (pieces[0].equals("move")) {
                if (firstContainer.contains() < Integer.valueOf(pieces[1])) {
                    secondContainer.add(firstContainer.contains());
                    firstContainer.remove(firstContainer.contains());
                } else {
                    secondContainer.add(Integer.valueOf(pieces[1]));
                    firstContainer.remove(Integer.valueOf(pieces[1]));
                }
            }

            if (pieces[0].equals("remove")) {
                secondContainer.remove(Integer.valueOf(pieces[1]));
            }
        }
    }
}
