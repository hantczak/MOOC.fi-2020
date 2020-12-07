import java.util.ArrayList;

public class ChangeHistory {
    private ArrayList<Double> history;

    public ChangeHistory() {
        this.history = new ArrayList<>();
    }

    public void add(double status) {
        this.history.add(status);
    }

    public void clear() {
        this.history.clear();
    }

    public double maxValue() {
        if (history.isEmpty()) {
            return 0;
        }
        double highest = history.get(0);
        for (Double change : history) {
            if (change > highest) {
                highest = change;
            }
        }
        return highest;
    }

    public double minValue(){
        if(history.isEmpty()){
            return 0;
        }
        double lowest=history.get(0);
        for(Double change:history){
            if(lowest>change){
                lowest=change;
            }
        }
        return lowest;
    }

    public double average(){
        double sum=0;
        int numberOfEntries=0;
        for (Double change:history){
            sum+=change;
            numberOfEntries++;
        }
        return sum/numberOfEntries;
    }

    public String toString() {
        return history.toString();
    }
}
