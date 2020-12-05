import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;

public class Library {
    private ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(String name, int minimumAge) {
        this.books.add(new Book(name, minimumAge));
    }

    public void sortByMinAgeAndName() {
        Comparator<Book> comparator = Comparator
                .comparing(Book::getMinAge)
                .thenComparing(Book::getName);
        Collections.sort(this.books, comparator);
    }

    public void printCollection() {
        System.out.println("");
        System.out.println(this.books.size() + " books in total.");
        System.out.println("");
        System.out.println("Books:");
        this.books.stream().forEach(book -> System.out.println(book));
    }
}