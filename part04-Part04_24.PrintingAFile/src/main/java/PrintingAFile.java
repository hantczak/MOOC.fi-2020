
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class PrintingAFile {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(Paths.get("data.txt"));

        while (scanner.hasNextLine()) {
            String row = scanner.nextLine();
            System.out.println(row);

        }
    }
}
