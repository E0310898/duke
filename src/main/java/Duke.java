import java.io.*;
import java.util.ArrayList;

public class Duke {

    private static String filePath = "D:/DukeDatabase/ArrayList";
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private File file = new File(filePath);

    public static void main(String[] args) throws DukeException {
        try{
        new Duke(filePath).run();
    }
        catch(DukeException e){
            e.getMessage();
        }
    }

    public Duke(String filePath) throws DukeException {
        ui = new Ui();
        storage = new Storage(filePath,file);

        try {
            tasks = new TaskList(storage.loadFile(file));
        }
        catch (DukeException e) {
            throw new DukeException(DukeException.FILE_DOES_NOT_EXIST());
        }
    }

    public void run() throws DukeException {
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
