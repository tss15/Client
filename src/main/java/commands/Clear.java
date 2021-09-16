package commands;

import java.io.IOException;

public class Clear extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public Clear(CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Clear() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Oops! Something went wrong");
        }
        commandReciever.clear();
    }

    @Override
    protected void writeInfo() {
        System.out.println("clear: clear collection");
    }
}
