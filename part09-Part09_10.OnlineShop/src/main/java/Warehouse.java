import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Warehouse {
    private Map<String, Integer> priceList;
    private Map<String, Integer> stockBalanceList;

    public Warehouse() {
        this.priceList = new HashMap<>();
        this.stockBalanceList = new HashMap<>();
    }

    public void addProduct(String product, int price, int stock) {
        priceList.put(product, price);
        stockBalanceList.put(product, stock);
    }

    public int price(String product) {
        return priceList.getOrDefault(product, -99);
    }

    public int stock(String product) {
        return stockBalanceList.getOrDefault(product, 0);
    }

    public boolean take(String product) {
        if (!(stockBalanceList.containsKey(product))) {
            return false;
        }
        if (stockBalanceList.getOrDefault(product, 0) >= 1) {
            int reducedAmount = stockBalanceList.get(product) - 1;
            stockBalanceList.put(product, reducedAmount);
            return true;
        }
        return false;
    }

    public Set<String > products(){
        return priceList.keySet();
    }
}

