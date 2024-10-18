public class Card {
    private boolean available = true;

    /* number or face that's on card - a number 2 through 10, or 11 for Jack, 12 for Queen, 13 for King, or 1 for Ace */
    protected int faceValue;
    protected Suit suit;

    public Card(int c, Suit s) {
        faceValue = c;
        suit = s;
    }

    public abstract int value();
    public Suit suit() { return suit; }

    public boolean isAvailable() { return available; }
    public void markUnavailable() { available = false; }
    public void markAvailable() { available = true; }
}

/*

Example to crate a card:

Card heartsAce = new Card(1, Suit.HEARTS);
CArd clubsJack = new Card(11, Suit.CLUBS);



 */