package commands;

import java.io.IOException;

public class UpdateID extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public UpdateID (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public UpdateID() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.updateId(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("update_id: update element by id");
    }
}
