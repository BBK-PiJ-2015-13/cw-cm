import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {
	private int id = 1;
	private int id2 = 2;
	private String name = "Steve";
	private String name2 = "Dave";
	private String note1 = "discussing the X project.";
	private Contact myContact;
	private Contact nonotes;
	private Contact nullname;
	private Contact nullnotes;
	private Contact negid;
	@Before
	public void buildUp() {
		myContact = new ContactImpl(id, name, note1);
		nonotes = new ContactImpl(id2, name2);
		//nullname = new MyContact(3, null, "hello");
	}
	@Test
	public void testsGetId() {
		int output = myContact.getId();
		int expected = id;
		assertEquals(output, expected);
	}
	@Test
	public void testsGetName() {
		String output = myContact.getName();
		String expected = name;
		assertEquals(output, expected);
	}
	@Test
	public void testsGetNotes() {
		String output = myContact.getNotes();
		String expected = note1;
		assertEquals(output, expected);
	}
	@Test
	public void testsGetnonotes() {
		String output = nonotes.getNotes();
		String expected = "";
		assertEquals(output, expected);
	}
	@Test
	public void testsAddnotes() {
		nonotes.addNotes("testing addnotes.");
		String expected = "testing addnotes.";
		String output = nonotes.getNotes();
		assertEquals(output, expected);
	}
	@Test
	public void testAddnewnotes() {
		myContact.addNotes(" Also discussing the Z project.");
		String expected = "discussing the X project. Also discussing the Z project.";
		String output = myContact.getNotes();
		assertEquals(output, expected);
	}
	@Test(expected= NullPointerException.class)
	public void testExceptions() {
		nullname = new MyContact(3, null, "hello");
		//String output = myContact.getName();
		//String expected = NullPointerException;
		//assertEquals(output, expected);
	}
	@After
	public void cleanUp() {
		myContact = null;
		nonotes = null;
	}
}