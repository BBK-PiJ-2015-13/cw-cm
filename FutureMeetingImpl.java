import java.util.Calendar;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;

public class FutureMeetingImpl implements FutureMeeting {

	private int id = 0;
	private Calendar date = null;
	private Set<Contact> someContacts = null;
	
	public FutureMeetingImpl(int id, Calendar date, Set<Contact> someContacts) {
		this.id = id;
		this.date = date;
		this.someContacts = someContacts;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Calendar getDate() {
		return this.date;
	}
	
	public Set<Contact> getContacts() {
		return this.someContacts;
	}

}