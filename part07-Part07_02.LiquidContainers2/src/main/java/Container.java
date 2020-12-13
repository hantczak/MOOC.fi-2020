public class Container {
    private int contentAmount;

    public Container() {
        this.contentAmount = 0;
    }

    public int contains() {
        return contentAmount;
    }

    public void add(int amount) {
        if (amount < 0) {

        } else if (this.contains() + amount >= 100) {
            this.contentAmount = 100;
        } else {
            this.contentAmount += amount;
        }

    }

    public void remove(int amount) {
        if (amount < 0) {

        } else if (this.contains() - amount <= 0) {
            this.contentAmount = 0;
        } else {
            this.contentAmount -= amount;
        }
    }

    public String toString() {
        return contentAmount + "/100";
    }
}
