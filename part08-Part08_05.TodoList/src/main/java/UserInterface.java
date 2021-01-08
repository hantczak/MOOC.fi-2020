import java.util.Scanner;

public class UserInterface {
    private TodoList todoList;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.todoList = list;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String command = scanner.nextLine();
            if (command.equals("stop")) {
                break;
            } else {
                processCommand(command);
            }
        }
    }

    public void processCommand(String command) {
        String userInput;
        int position;
        if (command.equals("add")) {
            System.out.print("To add: ");
            userInput = scanner.nextLine();
            todoList.add(userInput);
        }

        if (command.equals("list")) {
            todoList.print();
        }

        if (command.equals("remove")) {
            System.out.print("Which one is removed? ");
            position = Integer.valueOf(scanner.nextLine());
            todoList.remove(position);
        }
    }
}
