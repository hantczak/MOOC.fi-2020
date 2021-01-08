
import java.util.Scanner;

public class Login {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName1 = "alex";
        String userName2 = "emma";
        String password1 = "sunshine";
        String password2 = "haskell";
        System.out.print("Enter username: ");
        String userInput1 = scanner.nextLine();
        System.out.print("Enter password: ");
        String userInput2 = scanner.nextLine();

        if ((userInput1.equals(userName1) && userInput2.equals(password1) || (userInput1.equals(userName2) && userInput2.equals(password2)))) {
            System.out.println("You have successfully logged in!");
        }else {
            System.out.println("Incorrect username or password!");
        }
    }
}
