package commands;

import java.io.IOException;

public class CountByDifficulty extends Command {
    private static final long serialVersionUID = 32L;
    transient private CommandReceiver commandReciever;

    public CountByDifficulty (CommandReceiver commandReciever) {
        this.commandReciever = commandReciever;
    }

    public CountByDifficulty() {}

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 2) {
            System.out.println("Something went wrong (an irrelevant element was introduced)");
        }
        commandReciever.countByDiff(args[1]);
    }

    @Override
    protected void writeInfo() {
        System.out.println("count_by_difficulty: count elements by Difficulty");
    }
}
