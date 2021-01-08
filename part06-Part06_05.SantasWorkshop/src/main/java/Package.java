import java.util.ArrayList;

public class Package {
    private ArrayList<Gift> gifts;

    public Package(){
        gifts = new ArrayList<>();
    }

    public void addGift(Gift gift){
        this.gifts.add(gift);
    }

    public int totalWeight(){
        int summedWeight = 0;
        for (Gift gift:gifts){
            summedWeight += gift.getWeight();
        }
        return summedWeight;
    }
}
