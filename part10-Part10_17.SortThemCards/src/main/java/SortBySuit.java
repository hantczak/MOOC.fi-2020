import java.util.Comparator;

public class SortBySuit implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        return card1.getSuit().ordinal() - card2.getSuit().ordinal();
    }
}