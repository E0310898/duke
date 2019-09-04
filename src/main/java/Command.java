public abstract class Command {

    protected boolean exit;

    Command() {
        exit = false;
    }

    public abstract void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException;

    public boolean isExit() {
        return exit;
    }
}