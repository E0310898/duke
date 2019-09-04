import java.io.*;
import java.util.ArrayList;

public class Duke {

    private String filePath = "D:/DukeDatabase/ArrayList";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private File file = new File(filePath);

    public static void main(String[] args){
        new Duke().run();
    }

    public Duke(){
        ui = new Ui();
        storage = new Storage(this.filePath,file);

        try {
            tasks = new TaskList(storage.loadFile(file));
        }
        catch (DukeException e) {
            Ui.printMessage(e.getMessage());
        }
    }

    public void run(){
        Ui.printGreeting();
        boolean isExit = false;
        do {
            String userInput = Ui.readInput();
            try {
                Command command = Parser.parse(userInput);
                command.execute(tasks, ui, storage);
                isExit = command.isExit();
            }
            catch (DukeException e)
            {
               Ui.printMessage(e.getMessage());
            }
        } while (!isExit);
    }
}
