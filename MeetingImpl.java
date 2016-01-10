import java.util.Calendar;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public abstract class MeetingImpl implements Meeting {

	public int getId(){
		return 0;
	}
	
	public Calendar getDate() {
		Calendar x = new GregorianCalendar();
		return x;
	}
	
	public Set<Contact> getContacts() {
		Set<Contact> someContacts = new TreeSet<Contact>();
		return someContacts;
	}

}