public class Book implements Packable {
    private double weight;
    private String name;
    private String author;

    public Book(String author, String name, double weight){
        this.weight=weight;
        this.author=author;
        this.name=name;
    }

    public double weight(){
        return this.weight;
    }

    public String toString(){
        return this.author + ": " + this.name;
    }
}
