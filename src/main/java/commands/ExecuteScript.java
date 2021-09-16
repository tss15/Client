package commands;

import java.io.IOException;

public class ExecuteScript extends Command {
    private static final long serialVersionUID = 32L;
    transient  private CommandReceiver commandReciever;
    private static String path;

    public ExecuteScript (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public ExecuteScript() {}

    @Override
    protected void execute(String[] args) throws StackOverflowError, IOException {
        try {
            if (args.length > 2) {
                System.out.println("Wrong amount of arguments. For reference type help.");
            }
            else {
                path = args[1]; commandReciever.ExecuteScript(args[1]);
                ; }
        } catch (StackOverflowError ex) {
            System.out.println("Error! Stack overflow detected");
        } catch (InterruptedException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void writeInfo() {
        System.out.println("execute: read and execute script");
    }

    public static String getPath() {
        return path;
    }
}
