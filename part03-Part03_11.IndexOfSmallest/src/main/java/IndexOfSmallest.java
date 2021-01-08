
import java.util.ArrayList;
import java.util.Scanner;

public class IndexOfSmallest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> userInputNumbersList = new ArrayList<>();
        int userInputNumber = 0;
        while (true) {
            userInputNumber = Integer.valueOf(scanner.nextLine());
            if (userInputNumber == 999) {
                break;
            }
            userInputNumbersList.add(userInputNumber);
        }
        for (int number : userInputNumbersList) {
            System.out.println(number);
        }
        remove(userInputNumbersList);

        for (int number : userInputNumbersList) {
            System.out.println(number);
        }
    }

    public static void remove(ArrayList<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        int valueToBeRemoved = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < list.size(); i++) {
            list.remove(Integer.valueOf(valueToBeRemoved));
        }
    }
}

