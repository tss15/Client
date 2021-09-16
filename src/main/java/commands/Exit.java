package commands;

import java.io.IOException;

public class Exit extends Command {
    private CommandReceiver commandReciever;

    public Exit(CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Exit() {}

    @Override
    protected void execute(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Oops! Something went wrong");
        }
        commandReciever.exit();
    }

    @Override
    protected void writeInfo() {
        System.out.println("exit: exit without saving");
    }
}
