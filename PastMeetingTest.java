import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class PastMeetingTest {
	private PastMeeting myPast;
	private Set<Contact> myContactSet;
	private Calendar z;
	@Before
	public void buildUp() {
		myPast = new PastMeetingImpl(1, z, myContactSet, "Meeting with Steve.");
	}
	@Test
	public void testGetNotes() {
		String output = myPast.getNotes();
		String expected = "Meeting with Steve.";
		assertEquals(expected, output);
	}
	@After
	public void cleanUp() {
		myPast = null;
	}

}