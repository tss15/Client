package commands;

import java.io.IOException;

public class Info extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public Info(CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Info() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException  {
        if (args.length > 1) {
            System.out.println("Something went wrong");
        }
        commandReciever.info();
    }

    @Override
    protected void writeInfo() {
        System.out.println("info: print information about the collection (type, initialization date, number of elements, etc.) to the standard output stream.)");
    }
}
