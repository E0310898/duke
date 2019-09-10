import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Assertions;

/**
 * This class implements the unit testing code for the Deadline class.
 *
 * @author Sai Ganesh Suresh
 * @version v1.0
 */
public class DeadlineTest {

        SimpleDateFormat DATE_FORMATTER_DEADLINE = new SimpleDateFormat("dd/MM/yyyy HHmm");
        String dateDeadline;
    {
        try {
            dateDeadline = (DATE_FORMATTER_DEADLINE.parse("20/03/2018 1200")).toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    Deadline deadline = new Deadline("test deadline", "20/03/2018 1200");

    @Test
    public void testDeadlineCreation(){
        String title = deadline.description;
        Assertions.assertEquals(title, "test deadline");
        Assertions.assertEquals(deadline.toString(), "[D][" + "\u2718" + "] test deadline " +
                                                            "(by: 20/03/2018 1200)");
    }
}