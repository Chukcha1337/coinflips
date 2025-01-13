import java.util.List;

public class ConsolePrinter {



    public void showPlayersResults(String title, List<Player> players) {
        System.out.println(title);
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName());
            if (i != players.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public void showFlipResult(int result) {
        System.out.println("\nБросаем монетку");
        System.out.printf("Выпала сторона: %s\n\n",
                result == Coin.HEADS.getNumber() ? Coin.HEADS.getName() : Coin.TAILS.getName());
    }
}
