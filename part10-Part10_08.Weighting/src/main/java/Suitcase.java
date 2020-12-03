
import java.util.ArrayList;
import java.util.Comparator;

public class Suitcase {

    private int maximumWeight;
    private ArrayList<Item> items;

    public Suitcase(int maximumWeight) {
        this.items = new ArrayList<>();
        this.maximumWeight = maximumWeight;
    }

    public void addItem(Item Item) {
        if (this.totalWeight() + Item.getWeight() > this.maximumWeight) {
            return;
        }

        this.items.add(Item);
    }

    public int totalWeight() {
        int totalWeight = items.stream()
                .map(item -> item.getWeight())
                .reduce(0, (sum, value) -> sum + value);
        return totalWeight;
    }

    public void printItems() {
        items.stream()
                .map(item -> item.toString())
                .forEach(row -> System.out.println(row));
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }
        return this.items.stream().max(Comparator.comparingInt(Item::getWeight)).get();
    }

    @Override
    public String toString() {
        if (this.items.isEmpty()) {
            return "no items (0 kg)";
        }

        if (this.items.size() == 1) {
            return "1 item (" + this.totalWeight() + " kg)";
        }

        return this.items.size() + " items (" + this.totalWeight() + " kg)";
    }
}
