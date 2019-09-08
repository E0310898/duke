public class DeleteCommand extends Command{

    private int indexOfTask;

    public DeleteCommand(int indexOfTask) {
        this.indexOfTask = indexOfTask;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (indexOfTask > 0 && indexOfTask < (tasks.getSize() - 1)) {
            Task task = tasks.delete(indexOfTask);
            storage.saveFile(tasks.getTasks());
            Ui.printOutput("Noted. I've removed this task:" + "\n " + task.toString() + "\nNow you have " + tasks.getSize() + " task(s) in the list.");
        }
        else
        {
            throw new DukeException(DukeException.TASK_DOES_NOT_EXIST());
        }
    }
}