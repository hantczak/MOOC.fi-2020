package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoDao database;

    public UserInterface(Scanner scanner, TodoDao database) {
        this.scanner = scanner;
        this.database = database;
    }

    public void start() throws SQLException {
        while (true) {
            System.out.println("");
            System.out.println("Enter command:");
            System.out.println("1) list");
            System.out.println("2) add");
            System.out.println("3) mark as done");
            System.out.println("4) remove");
            System.out.println("x) quit");

            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("x")) {
                break;
            }
            processCommand(command);
            // implement the functionality here
        }

        System.out.println("Thank you!");
    }

    public void processCommand(String command) throws SQLException {

        if (command.equals("1")) {
            listContents();

        } else if (command.equals("2")) {
            add();

        } else if (command.equals("4")) {
            remove();

        } else if (command.equals("3")) {
            markAsDone();
        }
    }

    public void listContents() throws SQLException {
        List<Todo> taskList = database.list();
        System.out.println("Listing the database contents");
        for (Todo todo : taskList) {
            System.out.println(todo);
        }
    }

    public void add() throws SQLException {
        System.out.println("Adding a new todo");
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        database.add(new Todo(firstFreeIndex(), name, description, false));
    }

    public int firstFreeIndex() throws SQLException {
        return database.list().size();
    }

    public void remove() throws SQLException {
        System.out.println("Which todo should be removed (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        database.remove(id);
    }

    public void markAsDone() throws SQLException{
        System.out.println("Which todo should be marked as done (give the id)?");
        int id = Integer.valueOf(scanner.nextLine());
        database.markAsDone(id);
    }
}