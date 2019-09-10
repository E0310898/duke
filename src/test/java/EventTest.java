import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This class implements the unit testing code for the Event class.
 *
 * @author Sai Ganesh Suresh
 * @version v1.0
 */
public class EventTest {

        SimpleDateFormat DATE_FORMATTER_EVENT = new SimpleDateFormat("dd/MM/yyyy HHmm-HHmm");
        String dateEvent;
        {
            try {
                dateEvent = (DATE_FORMATTER_EVENT.parse("20/03/2018 1200-1300")).toString();;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        Event event = new Event("testing event", "20/03/2018 1200-1300");

        @Test
        public void testEventCreation(){
            String title = event.description;
            Assertions.assertEquals(title, "testing event");
            Assertions.assertEquals(event.toString(), "[E][" + "\u2718" + "] testing event " +
                                                             "(at: 20/03/2018 1200-1300)");
        }
}
