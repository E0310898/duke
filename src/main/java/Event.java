import java.io.Serializable;
import java.util.Date;

public class Event extends Task implements Serializable {

    private String date;

    public Event(String description, String date) {
        super(description);
        this.date = date;
    }
    @Override
    public String toString() {
        return "[E]" +  "[" + super.getStatusIcon() + "]" + this.description + "(at: " + date.toString() + ")";
    }
}
