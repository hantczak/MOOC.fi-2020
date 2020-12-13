import java.util.Scanner;

public class UserInterface {
    private Container container1;
    private Container container2;
    private Scanner scanner;

    public UserInterface(Container container1, Container container2, Scanner scanner) {
        this.container1 = container1;
        this.container2 = container2;
        this.scanner = scanner;
    }


    public void start() {
        printContainers(container1,container2);
        while (true) {

            String input = scanner.nextLine();
            if (input.equals("quit")) {
                break;
            } else this.processCommand(input);
        }
    }

    public void processCommand(String command) {
        String[] commandParts = command.split(" ");
        String inputCommand = commandParts[0];
        int inputAmount = Integer.valueOf(commandParts[1]);
        if (inputCommand.equals("add")) {
            this.add(inputAmount);

        } else if (inputCommand.equals("remove")) {
            this.remove(inputAmount);

        } else if (inputCommand.equals("move")) {
            this.move(inputAmount);
        } else {
            return;
        }
        this.printContainers(container1, container2);
    }

    public void printContainers(Container container1, Container container2) {
        System.out.println("First: " + container1);
        System.out.println("Second: " + container2);
    }

    public void add(int inputAmount) {
        container1.add(inputAmount);
    }

    public void remove(int inputAmount) {
        container2.remove(inputAmount);
    }

    public void move(int inputAmount) {
        if (inputAmount > 0) {
            if (container1.contains() < inputAmount) {
                container2.add(container1.contains());
                container1.remove(container1.contains());
            } else {
                container1.remove(inputAmount);
                container2.add(inputAmount);
            }
        }
    }
}
