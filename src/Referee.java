
import java.util.Map;
import java.util.Random;

public class Referee {
    private static final Random RANDOM = new Random();

    public int flip() {
        return RANDOM.nextInt(Coin.getSidesNumber());
    }

    public void setWinnerConditionForPlayers(int result, Map<Player, Boolean> players) {
        for (Map.Entry<Player, Boolean> entry : players.entrySet()) {
            if (entry.getKey().getPlayerBet() == result) {
                entry.setValue(true);
            }
        }
    }
}
