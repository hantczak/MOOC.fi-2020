import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {
    private int maxCapacity;
    private ArrayList<Item> items;

    public BoxWithMaxWeight(int capacity) {
        super();
        this.maxCapacity = capacity;
        items = new ArrayList<>();
    }

    public void add(Item newItem) {
        int weightSum = 0;
        for (Item item : items) {
            weightSum += item.getWeight();
        }
        if(weightSum+newItem.getWeight()<=maxCapacity){
            this.items.add(newItem);
        }
    }

    @Override
    public void add(ArrayList<Item> items) {
        int overallWeight = 0;
        for (Item item : items) {
            if (overallWeight + item.getWeight() > this.maxCapacity) {
                break;
            }
            overallWeight += item.getWeight();
            if (overallWeight < this.maxCapacity) {
                this.add(item);
            }
        }
    }

    @Override
    public boolean isInBox(Item comparedItem) {
        if (items.contains(comparedItem)) {
            return true;
        }
        return false;
    }
}
