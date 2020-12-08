import java.util.Comparator;

public class BySuitInValueOrder implements Comparator<Card> {
    public int compare(Card card1, Card card2) {
        if (card1.getSuit().ordinal() < card2.getSuit().ordinal()) {
            return -1;

        } else if (card1.getSuit().ordinal() == card2.getSuit().ordinal()) {
            if (card1.getValue() == card2.getValue()) {
                return 0;
            } else if (card1.getValue() < card2.getValue()) {
                return -1;
            } else if (card1.getValue() > card2.getValue()) {
                return 1;
            }

        }
        return 1;
    }
}