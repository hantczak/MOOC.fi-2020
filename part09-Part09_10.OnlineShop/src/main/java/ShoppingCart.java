import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> list;

    public ShoppingCart() {
        this.list = new ArrayList<>();
    }

    public void add(String product, int price) {
        boolean ifAlreadyPresent=false;
            for (Item item : list) {
                if (item.getName().equals(product)) {
                    item.increaseQuantity();
                    ifAlreadyPresent = true;
                }
            }
            if(!(ifAlreadyPresent)){
                list.add(new Item(product,1,price));
        }
    }


    public int price() {
        int totalPrice = 0;
        for (Item item : list) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void print() {
        for (Item item : list) {
            System.out.println(item);
        }
    }
}
