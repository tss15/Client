package commands;

import client.ClientSender;
import client.Session;
import data.Creator;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleManager {

    public void InteractiveMode(String hostName, String port) throws IOException {
        Session session = null;
        int delay = 0;

        try {
            session = new Session(hostName, Integer.parseInt(port));
            session.startSession();

            if (delay < 80) delay = 80;  // minimal delay 80
        } catch (NumberFormatException ex) {
            System.out.println("Check that the name is in string format, while port and dey in integer format");
            System.exit(0);
        } catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        ClientSender sender = new ClientSender(session);

        Creator creator = new Creator();
        CommandInvoker commandInvoker = new CommandInvoker();
        CommandReceiver commandReciever = new CommandReceiver(commandInvoker, sender, session.getSocketChannel(), delay, creator);

        commandInvoker.register("help", new Help(commandReciever));
//        commandInvoker.register("add", new Addd(commandReciever));
        commandInvoker.register("info", new Info(commandReciever));
        commandInvoker.register("show", new Show(commandReciever));
        commandInvoker.register("remove_difficulty", new RemoveDifficulty(commandReciever));
        commandInvoker.register("remove_key_null", new RemoveKeyNull(commandReciever));
        commandInvoker.register("remove_lower_key", new RemoveLowerkey(commandReciever));
        commandInvoker.register("replace_if_greater", new ReplaceIfGreater(commandReciever));
        commandInvoker.register("replace_if_lower", new ReplaceIfLower(commandReciever));
        commandInvoker.register("clear", new Clear(commandReciever));
        commandInvoker.register("exit", new Exit(commandReciever));
        commandInvoker.register("insert_null", new InsertNull(commandReciever));
//        commandInvoker.register("save", new Save(commandReciever));
        commandInvoker.register("update_id", new UpdateID(commandReciever));
        commandInvoker.register("count_by_difficulty", new CountByDifficulty(commandReciever));
        commandInvoker.register("print_field", new PrintField(commandReciever));
        commandInvoker.register("execute", new ExecuteScript(commandReciever));
//        commandInvoker.register("execute_script", new ExcecuteScript(commandReciever));
//        commandInvoker.register("print_field_descending_height", new DescengingHeight(commandReciever));
//        commandInvoker.register("print_field_ascending_height", new AscendingHeight(commandReciever));
//        commandInvoker.register("remove_last", new removeLast(commandReciever));


        try(Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                commandInvoker.executeCommand(scanner.nextLine().trim().split(" "));
            }
        }

        session.closeSession();
    }
}
