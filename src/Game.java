import java.util.ArrayList;
import java.util.List;

public class Game {

    private static final String NUMBER_OF_PLAYERS_TEXT = "Введите количество игроков: ";
    private static final String ERROR_MESSAGE = "Ошибка ввода";
    private static final List<Player> players = new ArrayList<>();
    private static final List<Player> winners = new ArrayList<>();
    private static final List<Player> losers = new ArrayList<>();
    private static final Referee referee = new Referee();

    public void start() {
        System.out.println("""
                ********************
                Орёл и решка
                ********************
                """);

        int numberOfPlayers = selectNumberOfPlayers();
        System.out.println();

        createPlayers(numberOfPlayers);
        getPlayersBets();

        int result = referee.flip();
        referee.showWinners(result, players, winners, losers);
    }

    private int selectNumberOfPlayers() {
        Dialog<Integer> dialog = new IntegerMinMaxDialog(NUMBER_OF_PLAYERS_TEXT,
                ERROR_MESSAGE,
                1,
                1_000);
        return dialog.input();
    }

    private void createPlayers(int numberOfPlayers) {
        for (int i = 1; i <= numberOfPlayers; i++) {
            players.add(new Player("Игрок %d".formatted(i)));
        }
    }

    private void getPlayersBets() {
        for (Player player : players) {
            player.bet(new IntegerMinMaxDialog(
                    "%s, введите вашу ставку (%d - %s, %d - %s): ".formatted(
                            player.getName(),
                            Coin.HEADS.getNumber(),
                            Coin.HEADS.getName(),
                            Coin.TAILS.getNumber(),
                            Coin.TAILS.getName()),
                    "Ошибка ввода",
                    Coin.HEADS.getNumber(),
                    Coin.TAILS.getNumber()));
        }
    }
}
