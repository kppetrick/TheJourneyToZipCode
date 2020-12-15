package console;

import java.util.Scanner;

public class ConsoleManager {
    private static Scanner playerConsoleInput;

    public ConsoleManager() {
        playerConsoleInput = new Scanner(System.in);
    }

    public static String playerInput() {
        return playerConsoleInput.nextLine();
    }
}
