public enum Suit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3);
    private int value;

    private Suit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Suit getSuitFromValue(int value) {
        switch(value) {
            case 0:
                return CLUBS;
            case 1:
                return DIAMONDS;
            case 2:
                return HEARTS;
            case 3:
                return SPADES;
            default:
                return null;
        }
    }
}
