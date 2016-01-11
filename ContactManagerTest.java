import org.junit.*;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.util.List;

public class ContactManagerTest {
	private ContactManager myContactManager;
	private PastMeeting myPast;
	private Contact myContact;
	private Set<Contact> myContactSet;
	private Calendar z;
	private String notes;
	private String name;
	private int id = 0;
	private int id2 = 2;
	@Before
	public void buildUp() {
		myContactManager = new ContactManagerImpl();
		myContact = new MyContact(id, name);
		z = new GregorianCalendar();
	}
	@Test
	public void testaddFutureMeeting() {
		int id = myContactManager.addFutureMeeting(myContactSet, z);
		Meeting returned = myContactManager.getFutureMeeting(id);
		Set<Contact> outputset = returned.getContacts();
		Calendar outputdate = returned.getDate();
		assertEquals(myContactSet, outputset);
		assertEquals(z, outputdate);
	}
	@Test
	public void testgetPastMeeting() {
		myContactManager.addNewPastMeeting(myContactSet, z, notes);
		myContactManager.getPastMeetingListFor(myContact);
		//myContactManager.getPastMeeting();
	}
	@Test
	public void testgetFutureMeeting() {
	//	myContactManager.add();
	}
	@Test
	public void testgetMeeting() {
	//	myContactManager.getMeeting(id);
	}
	@Test
	public void testgetFutureMeetingList() {
	//	List<Meeting> myFutureMeetingList = myContactManager.getFutureMeetingList(myContact);
		
	}
	@Test
	public void testgetMeetingListOn() {
		int idv = myContactManager.addFutureMeeting(myContactSet, z);
		List<Meeting> myMeetingDateList = myContactManager.getMeetingListOn(z);
		Meeting myMeet = myMeetingDateList.get(idv);
		Calendar output = myMeet.getDate();
		assertEquals(output, z);
	}
	@Test
	public void testgetPastMeetingListfor() {
		List<PastMeeting> myPastMeetingList = myContactManager.getPastMeetingListFor(myContact);
	}
	@Test
	public void testaddNewPastMeeting() {
		myPast = new PastMeetingImpl(id, z, myContactSet, notes);
		myContactManager.addNewPastMeeting(myContactSet, z, notes);
		PastMeeting output = myContactManager.getPastMeeting(id);
		PastMeeting expected = myPast;
		assertEquals(output, expected);
	}
	@Test
	public void testaddMeetingNotes() {
		int idx = myContactManager.addFutureMeeting(myContactSet, z);
		myContactManager.addMeetingNotes(idx, notes);
		PastMeeting myPastM = myContactManager.getPastMeeting(idx);
		String output = myPastM.getNotes();
		assertEquals(output, notes);
	}
	@Test
	public void testaddNewContact() {
		int x = myContactManager.addNewContact(name, notes);
		Set<Contact> y = myContactManager.getContacts(name);
		//Boolean z = y.contains();
		//String output = z.getName();
		//assertEquals(output, name);
	}
	@Test
	public void testgetContacts() {
		myContactManager.getContacts(name);
	}
	@Test
	public void testgetContactsids() {
		myContactManager.getContacts(id, id2);
	}
	@Test
	public void testFlush() {
		myContactManager.flush();
	}
	@After
	public void cleanUp() {
		myContactManager = null;
		myPast = null;
		myContact = null;
	}

}