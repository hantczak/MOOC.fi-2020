
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook recipeBook = new RecipeBook();
        UserInterface ui = new UserInterface(scanner,recipeBook);
        ui.start();

        System.out.println();
    }
}
