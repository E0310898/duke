/**
 * The DeleteCommand class is used when the user intends to delete a particular task from their task list.
 *
 * @author Sai Ganesh Suresh
 * @version v1.0
 */
public class DeleteCommand extends Command{

    private int indexOfTask;

    public DeleteCommand(int indexOfTask) {
        this.indexOfTask = indexOfTask;
    }
    /**
     * This execute function is used to add the respective tasks to the TaskList and save to persistent storage.
     *
     * @param tasks this string holds command type determinant to decide how to process the user input.
     * @param ui this string holds the description of the task provided by the user.
     * @param storage this parameter provides the execute function the storage to allow the saving of the file.
     * @throws DukeException The DukeException for task does not exist will be executed.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (indexOfTask >= 0 && indexOfTask <= (tasks.getSize() - 1)) {
            Task task = tasks.delete(indexOfTask);
            storage.saveFile(tasks.getTasks());
            Ui.printOutput("Noted. I've removed this task:" + "\n " + task.toString() + "\nNow you have "
                            + tasks.getSize() + " task(s) in the list.");
        }
        else
        {
            throw new DukeException(DukeException.TASK_DOES_NOT_EXIST());
        }
    }
}