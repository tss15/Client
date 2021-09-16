package commands;

import java.io.IOException;

public class RemoveDifficulty extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public RemoveDifficulty (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public RemoveDifficulty() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an unnecessary item was introduced)");
        }
        commandReciever.removeDif(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("remove_difficulty: remove element with given Difficulty");
    }
}
