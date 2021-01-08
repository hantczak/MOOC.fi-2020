
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) throws IOException {
        boolean stringFound = false;
        String file = null;
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Name of the file:");
            file = scanner.nextLine();

            System.out.println("Search for:");
            String searchedFor = scanner.nextLine();

            Scanner reader = new Scanner(Paths.get(file));

            while (reader.hasNextLine()) {
                if (reader.nextLine().equals(searchedFor)) {
                    System.out.println("Found!");
                    stringFound = true;
                    break;
                }
                stringFound = false;
            }

            if (stringFound == false) {
                System.out.println("Not found.");
            }


        } catch (Exception e) {
            System.out.println("Reading the file " + file + " failed.");

        }
    }
}
