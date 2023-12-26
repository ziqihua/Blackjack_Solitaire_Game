import java.util.*;

public class Deck {
    private ArrayList<Card> Cards;

    public Deck() {
        Cards = new ArrayList<Card>();
        String[] suits = {"C", "D", "H", "S"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        for (String suit : suits){
            for (String value : values) {
                Cards.add(new Card(value, suit));
            }
        }
        this.shuffle();
    }

    public void shuffle() {
        Collections.shuffle(Cards);
    }

    public Card drawCard(){
        return Cards.remove(0);
    }
}
