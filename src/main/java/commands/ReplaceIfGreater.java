package commands;

import java.io.IOException;

public class ReplaceIfGreater extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public ReplaceIfGreater (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public ReplaceIfGreater() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.replaceIfG(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("replace_if_greater: replace element if it's greater than the given");
    }
}
