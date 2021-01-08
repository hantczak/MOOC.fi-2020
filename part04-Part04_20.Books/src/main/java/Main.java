import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String title;
        int numberOfPages;
        int publicationYear;
        String userChoice;

        // implement here the program that allows the user to enter 
        // book information and to examine them
        ArrayList<Book> bookArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Title: ");
            title = scanner.nextLine();

            if (title.isEmpty()) {
                break;
            }

            System.out.println("Pages: ");
            numberOfPages = Integer.valueOf(scanner.nextLine());

            System.out.println("Publication year: ");
            publicationYear = Integer.valueOf(scanner.nextLine());

            bookArrayList.add(new Book(title, numberOfPages, publicationYear));
        }
        System.out.println("What information will be printed?");
        userChoice = scanner.nextLine();

        if (userChoice.equals("everything")) {
            for (Book book:bookArrayList){
                System.out.println(book.toString());
            }
        } else if (userChoice.equals("name")) {
            for (Book book:bookArrayList){
                System.out.println(book.getTitle());
            }

        }
    }
}
