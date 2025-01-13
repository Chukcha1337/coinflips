public enum Coin {
    HEADS(0, "ОРЕЛ"), TAILS(1, "РЕШКА");

    private final int NUMERICAL_REPRESENTATION;
    private final String SIDE_NAME;
    private static final int SIDES = 2;

    Coin(int numericalRepresentation, String sideName) {
        this.NUMERICAL_REPRESENTATION = numericalRepresentation;
        this.SIDE_NAME = sideName;
    }

    public int getNumber() {
        return NUMERICAL_REPRESENTATION;
    }

    public String getName() {
        return SIDE_NAME;
    }

    public static int getSidesNumber() {
        return SIDES;
    }
}
