/**
 * The ExitCommand class is used when the user inputs bye and intends to terminate the program.
 *
 * @author Sai Ganesh Suresh
 * @version v1.0
 */
public class ExitCommand extends Command {

    public ExitCommand() {
    }

    /**
     * This execute function calls the super.CommandOut function which is used to terminate the program by updating the
     * boolean flag exit to true.
     * @param tasks this string holds command type determinant to decide how to process the user input.
     * @param ui this string holds the description of the task provided by the user.
     * @param storage this parameter provides the execute function the storage to allow the saving of the file.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage){
        super.CommandOut();
        ui.printGoodbye();
    }

}
