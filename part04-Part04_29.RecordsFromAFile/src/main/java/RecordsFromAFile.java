
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class RecordsFromAFile {

    public static void main(String[] args) throws IOException {
        String line;
        String name;
        int age;
        String ageUnit;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name of the file: ");
        String fileName = scanner.nextLine();
        Scanner reader = new Scanner(Paths.get(fileName));

        while (reader.hasNextLine()) {
            line = reader.nextLine();
            String[] parts = line.split(",");
            name = parts[0];
            age = Integer.valueOf(parts[1]);

            if (age==1){
                ageUnit = "year";

            }else{
                ageUnit = "years";
            }

            System.out.println(name + ", age: " + age + " " + ageUnit);
        }
    }
}
