package commands;

import java.io.IOException;

public class RemoveLowerkey extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public RemoveLowerkey (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public RemoveLowerkey() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.removeLowerKey(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("remove_lower_key: remove an element with a key less than the given one ");
    }
}
