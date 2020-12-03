import java.util.ArrayList;

public class Herd implements Movable {
    private ArrayList<Movable> organisms;

    public Herd(){
        this.organisms = new ArrayList<>();
    }

    public void addToHerd(Movable movable){
        organisms.add(movable);
    }

    public void move(int dx, int dy){
        for(Movable organism:organisms){
            organism.move(dx,dy);
        }
    }

    public String toString(){
        String output = "";
        for(Movable organism:organisms){
            output += organism.toString() + "\n";
        }
        return output;
    }
}
