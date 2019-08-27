import java.io.Serializable;

public class Event extends Task implements Serializable {

    protected String at;

    public Event(String description, String at) throws DukeException {
        super(description);
        this.at = at;
        if (description.isBlank()) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        } else if (at.isBlank())
        {
            throw new DukeException("☹ OOPS!!! The date/duration of an event cannot be empty.");
        }
    }

    public String toString() {
        return "[E]" +  "[" + super.getStatusIcon() + "]" + this.description + "(at:" + at + ")";
    }
}