package commands;

import java.io.IOException;

public class InsertNull extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public InsertNull(CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public InsertNull() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.insertNull(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("insert_null: add new element to collection");
    }
}
