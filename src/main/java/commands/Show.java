package commands;

import java.io.IOException;

public class Show extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public Show(CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public Show() {}

    @Override
    protected void execute(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        if (args.length > 1) {
            System.out.println("Oops! Something went wrong");
        }
        commandReciever.show();
    }

    @Override
    protected void writeInfo() {
        System.out.println("show: print all elements of the collection in string representation.");
    }
}
