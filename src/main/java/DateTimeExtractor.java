import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * The DateTimeExtractor class is used to obtain the date specified by the user and recognize it as a date.
 *
 * @author Sai Ganesh Suresh
 * @version v1.0
 */

public class DateTimeExtractor {

    private static SimpleDateFormat DATE_FORMATTER_EVENT = new SimpleDateFormat("dd/MM/yyyy HHmm-HHmm");
    private static SimpleDateFormat DATE_FORMATTER_DEADLINE = new SimpleDateFormat("dd/MM/yyyy HHmm");
    private static String dateEvent;
    private static String dateDeadline;

    /**
     * The extractDateTime class is used to obtain the date specified by the user and recognize it as a date along with
     * extracting based on the type either event or deadline.
     *
     * @param dateTimeFromUser the raw date and time provided by the user.
     * @param command the command associated with the date provided.
     * @return a string is returned in the desired date time format for the corresponding task type.
     * @throws ParseException The date and time provided by the user was not of the correct format.
     */
    public static String extractDateTime(String dateTimeFromUser, String command) throws ParseException {

        if(command.equals("event")) {
            System.out.println(command);
            dateEvent = (DATE_FORMATTER_EVENT.parse(dateTimeFromUser)).toString();

            return dateEvent;
        }
        else if(command.equals("deadline")) {
            dateDeadline = (DATE_FORMATTER_DEADLINE.parse(dateTimeFromUser)).toString();
            return dateDeadline;
        }

        String dateUnknown = "00/00/0000";
        return dateUnknown;
    }
}
