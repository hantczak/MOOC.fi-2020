import java.util.*;

public class Hand implements Comparable<Hand> {
    private List<Card> cardList;

    public Hand() {
        this.cardList = new ArrayList<>();
    }

    public void add(Card card) {
        cardList.add(card);
    }

    public void print() {
        Iterator<Card> iterator = cardList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public void sort() {
        Comparator<Card> comparator = Comparator
                .comparing(Card::getValue)
                .thenComparing(Card::getSuit);
        Collections.sort(cardList, comparator);
    }

    public int compareTo(Hand hand) {
        int currentSum = this.cardList.stream()
                .map(row->row.getValue())
                .reduce(0, (previousSum, row) -> previousSum+row);


       int comparedSum = hand.cardList.stream()
                .map(row->row.getValue())
                .reduce(0,(previousSum,row) -> previousSum+row);
        if (currentSum<comparedSum){
            return -1;
        }else if(currentSum>comparedSum){
            return 1;
        }else {
            return 0;
        }
    }

    public void sortBySuit(){
        BySuitInValueOrder sortBySuitSorter = new BySuitInValueOrder();
        Collections.sort(cardList, sortBySuitSorter);
    }
}


