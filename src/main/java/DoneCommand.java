public class DoneCommand extends Command {
    private int indexOfTask;

    public DoneCommand(int indexOfTaskIndex) {
        this.indexOfTask = indexOfTaskIndex;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (indexOfTask < 0 || indexOfTask > (tasks.getSize() - 1)) {
            throw new DukeException(DukeException.TASK_DOES_NOT_EXIST());
        }

        Task task = tasks.markAsDone(indexOfTask);
        storage.saveFile(tasks.getTasks());

        Ui.printMessage("Nice! I've marked this task as done:");
        Ui.printMessage("  " + task.toString());
    }
}

