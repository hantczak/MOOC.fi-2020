public class Container {
    private int amountOfLiquid;

    public Container() {
        this.amountOfLiquid = 0;
    }

    public int contains() {
        return amountOfLiquid;
    }

    public void add(int amount) {
        if(amount<0){
            return;
        }

        if (this.amountOfLiquid + amount > 100) {
            this.amountOfLiquid = 100;
        } else {
            this.amountOfLiquid = this.amountOfLiquid + amount;
        }
    }

    public void remove(int amount){
        if(amount<0){
            return;
        }

        if(this.amountOfLiquid-amount<0){
            this.amountOfLiquid=0;
        }else {
            this.amountOfLiquid=this.amountOfLiquid-amount;
        }
    }

    public String toString(){
        return this.amountOfLiquid + "/100";
    }
}
