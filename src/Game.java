import java.util.*;

public class Game {

    private static final String NUMBER_OF_PLAYERS_TEXT = "Введите количество игроков: ";
    private static final String ERROR_MESSAGE = "Ошибка ввода";
    private static final Referee referee = new Referee();
    private static final Printer printer = new Printer();
    private static final Map<Player, Boolean> players = new LinkedHashMap<>();

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

        int flipResult = referee.flip();
        printer.printFlipResult(flipResult);

        referee.setWinnerConditionForPlayers(flipResult, players);
        printer.printPlayersResults("Выиграл(и)", "Проиграл(и)", players);
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
            players.put(new Player("Игрок %d".formatted(i)), false);
        }
    }

    private void getPlayersBets() {
        for (Map.Entry<Player, Boolean> entry : players.entrySet()) {
            Player player = entry.getKey();
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
