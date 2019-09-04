import java.io.Serializable;
import java.util.Date;

public class Deadline extends Task implements Serializable {

    private String date;

    public Deadline(String description, String date){
        super(description);
        this.date = date;
    }

    @Override
    public String toString() {
        return "[D]" + "[" + super.getStatusIcon() + "]" + this.description + "(by: " + date.toString() + ")";
    }
}

