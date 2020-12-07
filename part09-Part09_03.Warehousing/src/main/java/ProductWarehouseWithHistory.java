public class ProductWarehouseWithHistory extends ProductWarehouse {
    private ChangeHistory history;

    public ProductWarehouseWithHistory(String productName, double capacity, double initialBalance){
        super(productName,capacity);
        this.history = new ChangeHistory();
        this.addToWarehouse(initialBalance);
    }

    public String history(){
        return history.toString();
    }

    public void addToWarehouse(double amount){
        super.addToWarehouse(amount);
        history.add(getBalance());
    }

    @Override
    public double takeFromWarehouse(double amount) {
        double amountTaken = super.takeFromWarehouse(amount);
        history.add(getBalance());
        return amountTaken;
    }

    public void printAnalysis(){
        System.out.println("Product: " + this.getName());
        System.out.println("History: " + this.history);
        System.out.println("Largest amount of product: " + this.history.maxValue());
        System.out.println("Smallest amount of product: " + this.history.minValue());
        System.out.println("Average: " + this.history.average());
    }
}
