import java.util.Scanner;

public class IntegerMinMaxDialog implements Dialog<Integer> {
    private final String title;
    private final String error;
    private final int min;
    private final int max;

    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        this.title = title;
        this.error = error;
        this.min = min;
        this.max = max;
    }

    @Override
    public Integer input() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(title);
            String key = scanner.nextLine();

            if (isInteger(key)) {
                int number = Integer.parseInt(key);
                if (number >= min && number <= max) {
                    return number;
                }
            }

            System.out.println(error);
        }
    }

    private static boolean isInteger(String key) {
        try {
            Integer.parseInt(key);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}