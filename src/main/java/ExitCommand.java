public class ExitCommand extends Command{
    public ExitCommand (){
    }
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        exit = true;
        Ui.printGoodbye();
    }
}