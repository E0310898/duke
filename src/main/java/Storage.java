import java.io.*;
import java.util.ArrayList;

public class Storage {

    private static String filePath;
    private static File file;
    public Storage(String filePath, File file){
        this.filePath = filePath;
        this.file = file;
    }

    public void saveFile(ArrayList<Task> listOfTasks) throws DukeException {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(listOfTasks);
            objectOutputStream.close(); //always close
            fileOutputStream.close(); //always close
        }
        catch(IOException e)
        {
            throw new DukeException(DukeException.UNABLE_TO_WRITE_FILE());
        }
    }

    public ArrayList<Task> loadFile(File file) throws DukeException{

        ArrayList<Task> listOfTasks = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            listOfTasks = (ArrayList<Task>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
            return listOfTasks;
        }
        catch (FileNotFoundException e) {
            throw new DukeException(DukeException.FILE_DOES_NOT_EXIST());
        }
        catch (IOException e) {
            throw new DukeException(DukeException.UNABLE_TO_READ_FILE());
        }
        catch (ClassNotFoundException e) {
            throw new DukeException(DukeException.TASK_CLASS_DOES_NOT_EXIST());
        }
    }
}
