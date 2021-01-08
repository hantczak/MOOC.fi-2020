import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private TodoList todoList;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.todoList = todoList;
        this.scanner = scanner;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String userInput = this.scanner.nextLine();
            if (userInput.equals("stop")) {
                break;
            }

            if (userInput.equals("add")) {
                this.add();
            }

            if (userInput.equals("list")){
                this.list();
            }

            if (userInput.equals("remove")){
                this.remove();
            }
        }
    }

    public void add() {
        String userInput;
        System.out.print("To add: ");
        userInput = this.scanner.nextLine();
        todoList.add(userInput);
    }

    public void list() {
        todoList.print();
    }

    public void remove(){
        System.out.println("Which one is removed?");
        int removedID = Integer.valueOf(scanner.nextLine());
        todoList.remove(removedID);
    }
}
