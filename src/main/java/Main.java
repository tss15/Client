import commands.ConsoleManager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        try {
            ConsoleManager consoleManager = new ConsoleManager();
            consoleManager.InteractiveMode(args[0], args[1]);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Incorrect number of arguments: address, port required");
        }
    }
}
