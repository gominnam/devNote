public class Deck {
    private ArrayList cards;
    private int dealtIndex = 0;

    public void setDeckOfCards(ArrayList deckOfCards) {
        cards = deckOfCards;
    }

    public void shuffle() {
        for(int i = 0; i < cards.size(); i++) {
            int j = Random.nextInt(cards.size() - i) + i;
            Card card1 = cards.get(i);
            Card card2 = cards.get(j);
            cards.set(i, card2);
            cards.set(j, card1);
        }
    }

    public int remainingCards() {
        return cards.size() - dealtIndex;
    }

    public Card[] dealHand(int number) {
        if(remainingCards() < number) {
            return null;
        }

        Card[] hand = new Card[number];
        for(int i = 0; i < number; i++) {
            hand[i] = dealCard();
        }

        return hand;
    }
}