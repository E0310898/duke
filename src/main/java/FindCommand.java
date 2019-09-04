import java.util.ArrayList;

public class FindCommand extends Command{

    private String keyWord;

    public FindCommand(String keyWord) {
        this.keyWord = keyWord;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        ArrayList<Task> holdFoundTasks = tasks.find(keyWord);
        if (holdFoundTasks.isEmpty())
        {
            Ui.printMessage("There are no matching tasks in your list.");
        }
        else
        {
            Ui.printMessage("Here are the matching task(s) in your list:");
        }

        int i = 1;
        for (Task task : holdFoundTasks) {
            Ui.printMessage(i++ + "." + task.toString());
        }
    }
}