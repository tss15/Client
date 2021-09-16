package commands;

import java.io.IOException;

public class Help extends Command {
    private CommandReceiver commandReciever;

    public Help (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Help() {}

    @Override
    protected void execute(String[] args) throws IOException {
        if (args.length > 1) {
            System.out.println("Oops! Something went wrong");
        }
        commandReciever.help();
    }

    @Override
    protected void writeInfo() {
        System.out.println("help: display list of available commands");
    }
}
