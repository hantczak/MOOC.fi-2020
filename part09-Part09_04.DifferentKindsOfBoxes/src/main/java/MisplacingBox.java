import java.util.ArrayList;

public class MisplacingBox extends Box {
    private ArrayList<Item> items;

    public MisplacingBox(){
        items = new ArrayList<>();
    }

    public void add(Item newItem){
        this.items.add(newItem);
    }

    public void add(ArrayList<Item> newItems){
        for(Item item:newItems){
            this.items.add(item);
        }
    }

    public boolean isInBox(Item comparedItem){
        return false;
    }
}
