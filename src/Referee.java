
import java.util.List;
import java.util.Random;

public class Referee {
    private static final Random RANDOM = new Random();

    public int flip() {
        System.out.println("\nБросаем монетку");
        int result = RANDOM.nextInt(Coin.getSidesNumber());
        System.out.printf("Выпала сторона: %s\n", result == Coin.HEADS.getNumber() ? Coin.HEADS.getName() : Coin.TAILS.getName());
        return result;
    }

    public void showWinners(int result, List<Player> players, List<Player> winners, List<Player> losers) {
        for (Player player : players) {
            if (player.getPlayerBet() == result) {
                winners.add(player);
            } else {
                losers.add(player);
            }
        }
        System.out.println("\nВыиграл(и): ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\nПроиграл(и): ");
        for (int i = 0; i < losers.size(); i++) {
            System.out.print(losers.get(i).getName());
            if (i != losers.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
