import java.util.Date;

public class AddCommand extends Command {

    private String command;
    private String taskFeatures;
    private String formattedDateTime;

    public AddCommand(String command, String taskFeatures, String formattedDateTime) {
        this.command = command;
        this.taskFeatures = taskFeatures;
        this.formattedDateTime = formattedDateTime;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task task;
        switch (command) {
            case "todo":
                task = new Todo(taskFeatures);
                break;
            case "deadline":
                task = new Deadline(taskFeatures, formattedDateTime);
                break;
            case "event":
                task = new Event(taskFeatures, formattedDateTime);
                break;
            default:
                throw new DukeException(DukeException.UNKNOWN_USER_COMMAND());
        }

        tasks.add(task);
        storage.saveFile(tasks.getTasks());
        Ui.printOutput("Got it! I've added this task:" + "\n  " + task.toString() +"\nNow you have " + tasks.getSize() + " task(s) in the list.");
    }
}