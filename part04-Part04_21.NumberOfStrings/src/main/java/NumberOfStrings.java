
import java.util.Scanner;

public class NumberOfStrings {

    public static void main(String[] args) {
        String string;
        int i=0;

        Scanner scanner = new Scanner(System.in);


        while (true) {
            string = scanner.nextLine();
            if (string.equals("end")) {
                break;
            }
            i++;
        }
        System.out.println(i);
    }
}
