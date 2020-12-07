
public class Item {

    private String name;
    private int weight;

    public Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public Item(String name) {
        this(name, 0);
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean equals(Object compared){
        if(compared==this){
            return true;
        }

        if(!(compared instanceof Item)){
            return false;
        }

        Item comparedItem = (Item) compared;
        if(comparedItem.getName().equals(this.name)){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return this.name.hashCode();
    }
}
