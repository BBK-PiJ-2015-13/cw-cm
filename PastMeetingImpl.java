import java.util.Calendar;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;


public class PastMeetingImpl implements PastMeeting {
	
	private String notes = "";
	private int id = 0;
	private Calendar date = null;
	private Set<Contact> someContacts = null;
	
	public PastMeetingImpl(int id, Calendar date, Set<Contact> someContacts, String notes) {
		this.notes = notes;
		this.id = id;
		this.date = date;
		this.someContacts = someContacts;
	}

	public String getNotes() {
		return this.notes;
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