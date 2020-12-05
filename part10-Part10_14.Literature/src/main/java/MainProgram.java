
import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        UserInterface ui = new UserInterface(scanner, library);

        ui.getBooksFromUser();
        library.sortByMinAgeAndName();
        library.printCollection();
    }

}