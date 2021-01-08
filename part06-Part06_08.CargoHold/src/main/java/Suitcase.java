import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Item> items;
    private int maxItemsWeight;

    public Suitcase(int maxItemsWeight) {
        this.items = new ArrayList<>();
        this.maxItemsWeight = maxItemsWeight;
    }

    public void addItem(Item newItem) {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        if (totalWeight + newItem.getWeight() > this.maxItemsWeight) {
            return;
        } else {
            this.items.add(newItem);
        }
    }

    public String toString(){
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        String quantity;
        if(items.size()>1){
            quantity=" items ";
        }else{
            quantity=" item ";
        }
        if(items.size()==0){
            return "no items " + "(" + totalWeight + " kg)";
        }
        return items.size() + quantity + "(" + totalWeight + " kg)";
    }

    public void printItems(){
        String printout="";
        for (Item item:items){
            printout = printout +item.toString()+"\n";
        }
        System.out.println(printout);
    }


    public int totalWeight(){
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public Item heaviestItem(){
        if(items.isEmpty()){
            return null;
        }

        Item heaviest = items.get(0);
        for (Item item:items) {
            if (item.getWeight() > heaviest.getWeight()) {
                heaviest = item;
            }
        }
        return heaviest;
    }
}
