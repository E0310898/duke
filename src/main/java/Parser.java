import java.text.ParseException;
import java.util.Date;

public class Parser {

    public static Command parse(String userInput) throws DukeException {

        String command = userInput.split("\\s+", 2)[0].trim();
        String taskFeatures;
        String checkType;
        String description;
        int indexOfTask;

        switch (command) {
            case "todo":
                try {
                    taskFeatures = userInput.split("\\s+", 2)[1].trim();
                }catch (ArrayIndexOutOfBoundsException e)
                {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                }
                if (taskFeatures.isEmpty()) {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                } else {
                    return new AddCommand(command, taskFeatures, null);
                }
            case "deadline":
                try {
                    taskFeatures = userInput.split("\\s+", 2)[1].trim();
                }catch (ArrayIndexOutOfBoundsException e)
                {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                }
                if (taskFeatures.isEmpty()) {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                } else {
                    checkType = "/by";
                    String taskDescription = taskFeatures.split(checkType, 2)[0].trim();
                    if (taskDescription.isEmpty()) {
                        throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                    }
                    String formattedDateTime;
                    try {
                        String dateTimeFromUser = taskFeatures.split(checkType, 2)[1].trim();
                        formattedDateTime = DateTimeExtractor.extractDateTime(dateTimeFromUser, command);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new DukeException(DukeException.EMPTY_DATE_OR_TIME());
                    } catch (ParseException e) {
                        throw new DukeException(DukeException.WRONG_DATE_OR_TIME());
                    }
                    return new AddCommand(command, taskDescription, formattedDateTime);
                }
            case "event":
                try {
                    taskFeatures = userInput.split("\\s+", 2)[1].trim();
                }catch (ArrayIndexOutOfBoundsException e)
                {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                }
                if (taskFeatures.isEmpty()) {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                } else {
                    checkType = "/at";
                    String taskDescription = taskFeatures.split(checkType, 2)[0].trim();
                    if (taskDescription.isEmpty()) {
                        throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                    }
                    String formattedDateTime;
                    try {
                        String dateTimeFromUser = taskFeatures.split(checkType, 2)[1].trim();
                        formattedDateTime = DateTimeExtractor.extractDateTime(dateTimeFromUser, command);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        throw new DukeException(DukeException.EMPTY_DATE_OR_TIME());
                    } catch (ParseException e) {
                        throw new DukeException(DukeException.WRONG_DATE_OR_TIME());
                    }
                    return new AddCommand(command, taskDescription, formattedDateTime);
                }
            case "find":
                String findKeyWord = userInput.split(command, 2)[1].trim();
                if (findKeyWord.isEmpty()) {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                }
                return new FindCommand(findKeyWord);

            case "delete":
                description = userInput.split(command, 2)[1].trim();
                if (description.isEmpty()) {
                    throw new DukeException(DukeException.EMPTY_USER_DESCRIPTION());
                }
                indexOfTask = Integer.parseInt(description) - 1;
                return new DeleteCommand(indexOfTask);

            case "done":
                description = userInput.split(command, 2)[1].trim();
                if (description.isEmpty()) {
                    throw new DukeException(DukeException.UNKNOWN_USER_COMMAND());
                }

                indexOfTask = Integer.parseInt(description) - 1;
                return new DoneCommand(indexOfTask);
            case "list":
                return new ListCommand();
            case "bye":
                return new ExitCommand();
            default:
                // Empty string or unknown command.
                throw new DukeException(DukeException.UNKNOWN_USER_COMMAND());
        }
    }
}