public class Player {

    private final String name;
    private int playerBet;

    public Player(String name) {
        this.name = name;
    }

    public void bet(Dialog<Integer> betDialog) {
        playerBet = betDialog.input();
    }

    public String getName() {
        return name;
    }

    public int getPlayerBet() {
        return playerBet;
    }
}
