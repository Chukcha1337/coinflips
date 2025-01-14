
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Printer {

    public void printPlayersResults(String winnersMessage, String losersMessage, Map<Player, Boolean> players) {
        Function<Boolean, String> getPlayersByResult = result -> players.entrySet().stream()
                .filter(entry -> entry.getValue().equals(result))
                .map(entry -> entry.getKey().getName())
                .collect(Collectors.joining(", "));

        Map<String, String> resultsRepresentations = new LinkedHashMap<>();
        resultsRepresentations.put(winnersMessage, getPlayersByResult.apply(true));
        resultsRepresentations.put(losersMessage, getPlayersByResult.apply(false));

        for (Map.Entry<String, String> entry : resultsRepresentations.entrySet()) {
            if (!entry.getValue().isEmpty()) {
                System.out.println(entry.getKey() + ":\n" + entry.getValue() + "\n");
            }
        }
    }

    public void printFlipResult(int result) {
        System.out.printf("""
                        
                        Бросаем монетку
                        Выпала сторона: %s
                        
                        """,
                result == Coin.HEADS.getNumber() ? Coin.HEADS.getName() : Coin.TAILS.getName());
    }
}
