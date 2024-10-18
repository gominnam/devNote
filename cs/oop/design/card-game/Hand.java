public class Hand {
    protected ArrayList cards = new ArrayList();

    public int score() {
        int score = 0;
        for(Card card : cards) {
            score += card.value();
        }
        return score;
    }

    public void addCard(Card card) {
        cards.add(card);
    }
}