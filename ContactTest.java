import org.junit.*;
import static org.junit.Assert.*;

public class ContactTest {
	private Contact myContact;
	private Contact nonotes;
	@Before
	public void buildUp {
		myContact = new Contact(1, "Steve", "discussing the X project.");
		nonotes = new Contact(2, "Dave");
	}
	@Test
	public void testsGetId() {
		int output = myContact.getId();
		int expected = 1;
		assertEquals(output, expected);
	}
	@Test
	public void testsGetName {
		String output = myContact.getName();
		String expected = "Steve";
		assertEquals(output, expected);
	}
	@Test
	public void testsGetNotes {
		String output = myContact.getNotes();
		String expected = "discussing the x project.";
		assertEquals(output, expected);
	}
	@Test
	public void testsGetnonotes {
		String output = nonotes.getNotes();
		String expected = "";
		assertEquals(output, expected);
	}
	@Test
	public void testsAddnotes{
		String input = nonotes.addNotes("testing addnotes.");
		String expected = nonotes.getNotes();
		assertEquals(input, expected);
	}
	@After
	public void cleanUp {
		myContact = null;
		nonotes = null;
	}
}