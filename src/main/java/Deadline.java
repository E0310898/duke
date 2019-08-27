import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deadline extends Task implements Serializable {

    protected String by;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm"); //according to the specification given in the Level-8 description
    private Date date;

    public Deadline(String description, String by) throws DukeException, ParseException {
        super(description);
        this.by = by;

        date = format.parse(by);

        if (description.isBlank()) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
        else if (by.isBlank())
        {
            throw new DukeException("☹ OOPS!!! The deadline date/time cannot be empty.");
        }
    }

    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "]" + this.description + "(by: " + date.toString() + ")";
    }
}

