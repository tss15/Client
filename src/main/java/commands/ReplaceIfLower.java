package commands;

import java.io.IOException;

public class ReplaceIfLower extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public ReplaceIfLower (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public ReplaceIfLower() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.replaceIfL(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("replace_if_lower: replace element if it's lower than the given");
    }
}
