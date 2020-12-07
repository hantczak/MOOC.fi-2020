import java.util.ArrayList;

public class Box implements Packable{
    private double maximumCapacity;
    private ArrayList<Packable> contents;

    public Box(double maximumCapacity) {
        this.maximumCapacity = maximumCapacity;
        contents = new ArrayList<>();
    }

    public void add(Packable item) {
        if (weigh()+item.weight()<=maximumCapacity){
            contents.add(item);
        }
    }

    public double weight() {
        return weigh();
    }

    public double weigh() {
        double overallWeight = 0;
        for (Packable item : contents) {
            overallWeight += item.weight();
        }
        return overallWeight;
    }

    public String toString(){
        return "Box: " +contents.size() + " items, total weight " + weigh() + " kg";
    }
}
