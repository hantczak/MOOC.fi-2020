import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private SimpleDictionary simpleDictionary;

    public TextUI(Scanner scanner, SimpleDictionary simpleDictionary) {
        this.scanner = scanner;
        this.simpleDictionary = simpleDictionary;
    }

    public void start() {
        while (true) {
            System.out.print("Command: ");
            String userInput = scanner.nextLine();
            if (userInput.equals("end")) {
                System.out.println("Bye bye!");
                break;
            } else {
                processCommand(userInput);
            }


        }
    }

    public void processCommand(String command) {
        if (command.equals("add")) {
            this.add();

        } else if (command.equals("search")) {
            this.search();

        } else {
            System.out.println("Unknown command");
        }
    }

    public void search() {
        System.out.print("To be translated: ");
        String word = this.scanner.nextLine();
        String translation = simpleDictionary.translate(word);
        if (translation == null) {
            System.out.println("Word " + word + " was not found");
        } else {
            System.out.println("Translation: " + translation);
        }
    }

    public void add() {
        String originalWord;
        String translatedWord;
        System.out.print("Word: ");
        originalWord = scanner.nextLine();
        System.out.print("Translation: ");
        translatedWord = scanner.nextLine();
        simpleDictionary.add(originalWord, translatedWord);
        return;
    }
}
