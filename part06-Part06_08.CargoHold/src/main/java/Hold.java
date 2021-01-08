import java.util.ArrayList;

public class Hold {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        suitcases = new ArrayList<>();
    }

    public void addSuitcase(Suitcase newSuitcase) {
        int totalWeight = 0;
        for (Suitcase suitcase : suitcases) {
            totalWeight += suitcase.totalWeight();
        }
        if (totalWeight + newSuitcase.totalWeight() > maxWeight) {
            return;
        }
        suitcases.add(newSuitcase);
    }

    public String toString() {
        int totalWeight = 0;
        for (Suitcase suitcase : suitcases) {
            totalWeight += suitcase.totalWeight();
        }
        return suitcases.size() + " suitcases " + "(" + totalWeight + " kg)";
    }

    public void printItems(){
        for (Suitcase suitcase:suitcases){
            suitcase.printItems();
        }
    }
}
