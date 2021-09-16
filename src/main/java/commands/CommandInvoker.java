package commands;

import java.io.IOException;
import java.util.HashMap;

public class CommandInvoker {
    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    public void executeCommand(String[] commandName) {
        try {
            if (commandName.length > 0 && !commandName[0].equals("")) {
                Command command = commandMap.get(commandName[0]);
                command.execute(commandName);
            } else { System.out.println("Command not chosen."); }}
        catch (NullPointerException ex) {
            System.out.println("Such command " + commandName[0] + " doesn't exist. Use help");}
        catch (ArrayIndexOutOfBoundsException ex) {System.out.println("Check the argument chosen by you and try again");}
        catch (IllegalStateException | IOException | ClassNotFoundException | InterruptedException ex) {
            if (ex.getMessage().equals("Connection reset by peer")) {
                System.out.println("dead");
                System.exit(0);
            }
            System.out.println(ex.getMessage());
        }
    }

    HashMap<String, Command> getCommandMap() {
        return commandMap;
    }
}