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
	@Before
	public void buildUp() {
		myContact = new MyContact(id, name, note1);
		nonotes = new MyContact(id2, name2);
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
		String doit = note1;
		assertEquals(output, doit);
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
		String input = "testing addnotes.";
		String expected = nonotes.getNotes();
		assertEquals(input, expected);
	}
	@After
	public void cleanUp() {
		myContact = null;
		nonotes = null;
	}
}