package commands;

import java.io.IOException;

public class Save extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public Save (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Save() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException  {
        if (args.length > 1) {
            System.out.println("Something went wrong");
        }
        commandReciever.save();
    }

    @Override
    protected void writeInfo() {
        System.out.println("save: save");
    }
}
