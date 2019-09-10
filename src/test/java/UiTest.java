import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class implements the unit testing code for the DukeTest class.
 *
 * @author Sai Ganesh Suresh
 * @version v1.0
 */
public class UiTest {
    Ui ui = new Ui();
    @Test
    public void testUiCreation(){
        String testUi = ui.readInput();
        Assertions.assertEquals(testUi, "bye");
    }
}
