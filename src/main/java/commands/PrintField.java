package commands;

import java.io.IOException;

public class PrintField extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public PrintField (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public PrintField() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException  {
        if (args.length > 1) {
            System.out.println("Something went wrong");
        }
        commandReciever.printField();
    }

    @Override
    protected void writeInfo() {
        System.out.println("print_field: sort the collection in natural order");
    }
}
