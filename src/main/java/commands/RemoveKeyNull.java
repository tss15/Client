package commands;

import java.io.IOException;

public class RemoveKeyNull extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public RemoveKeyNull (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public RemoveKeyNull() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.removeKeyNull(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("remove_key_null: remove element by given key");
    }
}
