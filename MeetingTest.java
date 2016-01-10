import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class MeetingTest {
	private Meeting myMeeting;
	private Contact myContact;
	
	@Before
	public void buildUp() {
		myMeeting = new MyMeeting(1, 31, myContact);
	}
	@Test
	public void testGetID() {
		int output = myContact.getID();
		int expected = 1;
		assertEquals(expected, output);
	}
	
	@Test
	public Calendar testGetDate() {
		int output = myMeeting.getDate();
		int expected = 31;
		assertEquals(expected, output);
	}
	@Test
	public Set<Contact> testgetContact() {
		Set<Contact> output = myMeeting.getContacts();
		Set<Contact> expected = myContact;
		assertEquals(expected, output);
	}
	@After
	public void cleanUp() {
		myContact = null;
	}

}