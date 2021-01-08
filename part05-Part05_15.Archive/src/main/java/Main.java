
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Item> itemList = new ArrayList<>();
        String identifier;
        String name;
        boolean isAlreadyInTheList = false;

        while (true) {
            System.out.println("Identifier? (empty will stop)");
            identifier = scanner.nextLine();
            if (identifier.equals("")) {
                break;
            }
            System.out.println("Name? (empty will stop)");
            name = scanner.nextLine();
            if (name.equals("")) {
                break;
            }

            for (Item item : itemList) {
                if (item.getIdentifier().equals(identifier)) {
                    isAlreadyInTheList = true;
                    break;
                }
            }
            if (isAlreadyInTheList == false) {
                itemList.add(new Item(identifier, name));
            }
        }

        System.out.println("==Items==");
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }
}
