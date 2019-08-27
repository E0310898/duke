import java.io.Serializable;

public class Deadline extends Task implements Serializable {

    protected String by;

    public Deadline(String description, String by) throws DukeException {
        super(description);
        this.by = by;
        if (description.isBlank()) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        } else if (by.isBlank())
        {
            throw new DukeException("☹ OOPS!!! The deadline date/time cannot be empty.");
        }
    }

    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "]" + this.description + "(by:" + by + ")";
    }
}

