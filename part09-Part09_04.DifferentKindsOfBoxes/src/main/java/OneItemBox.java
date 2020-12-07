import java.util.ArrayList;

public class OneItemBox extends Box {
    private ArrayList<Item> item;

    public OneItemBox() {
        super();
        item = new ArrayList<>();
    }

    public void add(Item newItem) {
        if (this.item.size()==0) {
            this.item.add(newItem);
        }
    }

    public void add(ArrayList<Item> items) {
        if (this.item.size()==0) {
            this.item.add(items.get(0));
        }
    }

    public boolean isInBox(Item comparedItem) {
        if (this.item.contains(comparedItem)) {
            return true;
        }
        return false;
    }
}
