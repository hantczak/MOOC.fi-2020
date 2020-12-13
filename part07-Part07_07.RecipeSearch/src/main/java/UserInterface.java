import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private RecipeBook recipeBook;

    public UserInterface(Scanner scanner, RecipeBook recipeBook) {
        this.scanner = scanner;
        this.recipeBook = recipeBook;
    }

    public void start() {
        String inputCommand;
        String inputFilename = "";
        System.out.print("Files to read: ");
        inputFilename = scanner.nextLine();
        this.readFile(inputFilename);

        displayListOfCommands();
        while (true) {
            System.out.print("Enter command: ");
            inputCommand = scanner.nextLine();
            if (inputCommand.equals("stop")) {
                break;
            }
            processCommand(inputCommand);
        }
    }

    public void readFile(String inputFilename) {
        String recipeName = "";
        String cookingDuration;
        ArrayList<String> ingredients;
        try (Scanner reader = new Scanner(Paths.get(inputFilename))) {
            while (reader.hasNextLine()) {
                recipeName = reader.nextLine();
                cookingDuration = reader.nextLine();
                ingredients = readIngredients(reader);
                recipeBook.addRecipe(recipeName, cookingDuration, ingredients);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ArrayList<String> readIngredients(Scanner reader) {
        String nextLine;
        ArrayList<String> ingredients = new ArrayList<>();
        while (reader.hasNextLine()) {
            nextLine = reader.nextLine();
            if (nextLine.equals("")) {
                break;
            }
            ingredients.add(nextLine);
        }
        return ingredients;
    }

    public void processCommand(String inputCommand) {
        if (inputCommand.equals("list")) {
            printRecipeBook();
        }

        if (inputCommand.equals("find name")) {
            this.printRecipeArray(this.searchByName());
        }

        if (inputCommand.equals("find cooking time")) {
            this.printRecipeArray(this.searchByCookingTime());
        }

        if (inputCommand.equals("find ingredient")) {
            this.printRecipeArray(this.searchByIngredient());
        }

    }

    public void displayListOfCommands() {
        System.out.println();
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient" + "\n");
    }

    public void printRecipeBook() {
        System.out.println(recipeBook.toString());
    }

    public ArrayList<Recipe> searchByName() {
        System.out.print("Searched word: ");
        Scanner scanner = new Scanner(System.in);
        String searchedName = scanner.nextLine();
        return recipeBook.findName(searchedName);
    }

    public void printRecipeArray(ArrayList<Recipe> list) {
        System.out.println();
        System.out.println("Recipes:");
        for (Recipe recipe : list) {
            System.out.println(recipe.toString());
        }
        System.out.println();
    }

    public ArrayList<Recipe> searchByCookingTime() {
        System.out.print("Max cooking time: ");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        return recipeBook.findRecipesWithCookingTimeBelow(userInput);
    }

    public ArrayList<Recipe> searchByIngredient() {
        System.out.print("Ingredient: ");
        String userInput = scanner.nextLine();
        return recipeBook.searchByIngredient(userInput);
    }
}
