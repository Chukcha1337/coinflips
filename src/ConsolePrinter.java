import java.util.List;
import java.util.stream.Collectors;

public class ConsolePrinter {


    public void showPlayersResults(String title, List<Player> players) {
        if (!players.isEmpty()) {
            String playersNames = players
                    .stream()
                    .map(Player::getName)
                    .collect(Collectors.joining(", "));
            System.out.println("\n" + title + "\n" + playersNames);
        }

    }

    public void showFlipResult(int result) {
        System.out.println("\nБросаем монетку");
        System.out.printf("Выпала сторона: %s\n",
                result == Coin.HEADS.getNumber() ? Coin.HEADS.getName() : Coin.TAILS.getName());
    }
}
