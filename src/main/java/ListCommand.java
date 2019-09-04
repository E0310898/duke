public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        if (tasks.getSize() == 0)
        {
            Ui.printOutput("You have currently no tasks in your list.");
        }
        else
        {
            Ui.printDash();
            Ui.printMessage("Here are the task(s) in your list:");
            int i = 1;
            for (Task task : tasks.getTasks()) {
                Ui.printMessage(i++ + "." + task.toString());
            }
            Ui.printDash();
        }
    }
}
