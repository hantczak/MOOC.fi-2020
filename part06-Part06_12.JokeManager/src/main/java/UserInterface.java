import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private JokeManager jokeManager;

    public UserInterface(JokeManager jokeManager, Scanner scanner) {
        this.scanner = scanner;
        this.jokeManager = jokeManager;
    }

    public void start() {
        while (true) {
            System.out.println("Commands:");
            System.out.println(" 1 - add a joke");
            System.out.println(" 2 - draw a joke");
            System.out.println(" 3 - list jokes");
            System.out.println(" X - stop");
            String command = scanner.nextLine();
            if (command.equals("X")) {
                return;
            } else {
                processCommand(command);
            }
        }
    }

    public void processCommand(String command) {
        if (command.equals("1")) {
            System.out.println("Write the joke to be added:");
            String newJoke = scanner.nextLine();
            jokeManager.addJoke(newJoke);

        } else if (command.equals("2")) {
            System.out.println(jokeManager.drawJoke());
        } else if (command.equals("3")) {
            jokeManager.printJokes();
        }
    }
}