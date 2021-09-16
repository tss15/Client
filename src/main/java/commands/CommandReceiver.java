package commands;

import client.ClientSender;
import client.Receiver;
import data.Creator;
import data.LabWork;
import tools.SerializedArgumentCommand;
import tools.SerializedCombinedCommand;
import tools.SerializedSimplyCommand;

import java.io.*;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class CommandReceiver {
    private final CommandInvoker commandInvoker;
    private final ClientSender sender;
    private final SocketChannel socketChannel;
    private final Integer delay;
    private final Creator creator;

    public CommandReceiver(CommandInvoker commandInvoker, ClientSender sender, SocketChannel socketChannel, Integer delay, Creator creator) {
        this.commandInvoker = commandInvoker;
        this.sender = sender;
        this.socketChannel = socketChannel;
        this.delay = delay;
        this.creator = creator;
    }



    public void help() {
        commandInvoker.getCommandMap().forEach((name,command) -> command.writeInfo());
    }

    public void info() throws IOException, ClassNotFoundException, InterruptedException {
        sender.toSend(new SerializedSimplyCommand(new Info()));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void show() throws IOException, ClassNotFoundException, InterruptedException {
        sender.toSend(new SerializedSimplyCommand(new Show()));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }
    public void save() throws IOException, ClassNotFoundException, InterruptedException {
        sender.toSend(new SerializedSimplyCommand(new Save()));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }
    public void printField() throws IOException, ClassNotFoundException, InterruptedException {
        sender.toSend(new SerializedSimplyCommand(new PrintField()));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }
    public void countByDiff(String option) throws IOException, ClassNotFoundException, InterruptedException {
        sender.toSend(new SerializedArgumentCommand(new CountByDifficulty(), option));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }
    public void updateId(String in) throws IOException, ClassNotFoundException, InterruptedException {
        sender.toSend(new SerializedCombinedCommand(new UpdateID(), Creator.LabWorkCreate(),Integer.parseInt(in)));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }
    public void insertNull(String id) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedCombinedCommand(new InsertNull(), Creator.LabWorkCreate(),Integer.parseInt(id)));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void removeDif(String ID) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedArgumentCommand(new RemoveDifficulty(), ID));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void removeKeyNull(String ID) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedArgumentCommand(new RemoveKeyNull(), ID));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void removeLowerKey(String ID) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedArgumentCommand(new RemoveLowerkey(), ID));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void replaceIfG(String id) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedCombinedCommand(new ReplaceIfGreater(), Creator.LabWorkCreate(),Integer.parseInt(id)));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void replaceIfL(String id) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedCombinedCommand(new ReplaceIfLower(), Creator.LabWorkCreate(),Integer.parseInt(id)));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }




    public void clear() throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedSimplyCommand(new Clear()));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
    }

    public void exit() throws IOException {
        socketChannel.close();
        System.out.println("The end!");
        System.exit(0);
    }

    /**
     * @param path path to file
     */

    public void ExecuteScript(String path) throws IOException, InterruptedException, ClassNotFoundException {
        sender.toSend(new SerializedArgumentCommand(new ExecuteScript(), path));
        Thread.sleep(delay);
        Receiver.receive(socketChannel);
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(path))){
            while ((line = reader.readLine()) != null) {
                commandInvoker.executeCommand(line.split(" "));
            }
        } catch (IOException e) {
            System.out.println("Error! " + e.getMessage());
        }
//                if (line.split(" ")[0].matches("insert_null|update")) {
//                    command = line;
//
//                    for (int i = 0; i < 13; i++) {
//                        if (line != null) {
//                            line = bufferedReader.readLine();
//                            field.add(line);
//                        } else {
//                            System.out.println("Не хватает параметров для создания объекта.");
//                            break;
//                        }
//                    }
//                    LabWork lab = Creator.ScriptFromJsonToCollection(field);
//                    switch (command.split(" ")[0]) {
//
//                        case "insert_null":
//                            sender.toSend(new SerializedCombinedCommand(new InsertNull(), creator.LabWorkCreate(), Integer.parseInt(command.split(" ")[1])));
//                            Thread.sleep(delay);
//                            Receiver.receive(socketChannel);
//                            break;
//                        case "update":
//                            sender.toSend(new SerializedCombinedCommand(new UpdateID(), creator.LabWorkCreate(), Integer.parseInt(command.split(" ")[1])));
//                            Thread.sleep(delay);
//                            Receiver.receive(socketChannel);
//                            break;
//                    }}
//                else {

              //  }

    }

    /*
    SIMPLY COMMAND?
     */

//    public void removeLast() throws IOException, InterruptedException, ClassNotFoundException {
//        sender.toSend(new SerializedSimplyCommand(new removeLast()));
//        Thread.sleep(delay);
//        Receiver.receive(socketChannel);
//    }
//
//    public void descendingHeight() throws IOException, InterruptedException, ClassNotFoundException {
//        sender.toSend(new SerializedSimplyCommand(new DescendingHeight()));
//        Thread.sleep(delay);
//        Receiver.receive(socketChannel);
//    }
//
//    public void ascendingHeight() throws IOException, InterruptedException, ClassNotFoundException {
//        sender.toSend(new SerializedSimplyCommand(new AscendingHeight()));
//        Thread.sleep(delay);
//        Receiver.receive(socketChannel);
//    }
}
