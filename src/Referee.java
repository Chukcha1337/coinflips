
import java.util.List;
import java.util.Random;

public class Referee {
    private static final Random RANDOM = new Random();

    public int flip() {
        return RANDOM.nextInt(Coin.getSidesNumber());
    }

    public void selectWinnersAndLosers(int result, List<Player> players, List<Player> winners, List<Player> losers) {
        for (Player player : players) {
            if (player.getPlayerBet() == result) {
                winners.add(player);
            } else {
                losers.add(player);
            }
        }
    }
}
