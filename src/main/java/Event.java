import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Event extends Task implements Serializable {

    protected String at;

    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm-HHmm"); //according to the specification given in the Level-8 description
    private Date date;

    public Event(String description, String at) throws DukeException, ParseException {
        super(description);
        this.at = at;

        date = format.parse(at);

        if (description.isBlank()) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        } else if (at.isBlank())
        {
            throw new DukeException("☹ OOPS!!! The date/duration of an event cannot be empty.");
        }
    }

    public String toString() {
        return "[E]" +  "[" + super.getStatusIcon() + "]" + this.description + "(at: " + date.toString() + ")";
    }
}
