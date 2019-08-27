import java.io.Serializable;

public class Todo extends Task implements Serializable {

    public Todo(String description) throws DukeException {
        super(description);
            if (description.isBlank()) {
                throw new DukeException("☹ OOPS!!! The description of a todo task cannot be empty.");
            }
        }

    public String toString() {
        return "[T]" + "[" + super.getStatusIcon() + "]" + this.description;
    }
}
