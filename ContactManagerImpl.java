import java.util.List;
import java.util.LinkedList;
import java.util.Calendar;
import java.util.Set;
import java.util.GregorianCalendar;
import java.util.TreeSet;
import java.util.Iterator;
import java.io.*;

public class ContactManagerImpl implements ContactManager {
	//int counter for objects of FutureMeeting. Corresponds to id value in myFutureMeetingList. Incremented by calling addFutureMeeting and decremented by calling addMeetingNotes.
	private int countfuture = -1;
	//int counter for objects of PastMeeting. Corresponds to id value in myPastMeetingList. Incremented by calling addNewPastMeeting and addMeetingNotes.
	private int countpast = -1;
	//int counter for Contact objects. Corresponds to length of myContactList. Incremented by calling addNewContact.
	private int contactcount = -1;
	//Lists FutureMeeting objects for use in addFutureMeeting, getFutureMeeting, getFutureMeetingList and getMeetingListOn methods.
	private List<FutureMeeting> myFutureMeetingList = new LinkedList<FutureMeeting>();
	//Lists Meeting objects.
	private List<Meeting> myMeetingList = new LinkedList<Meeting>();
	//Lists PastMeeting objects for use in addNewPastMeeting, addMeetingNotes, getPastMeeting and getPastMeetingListFor.
	private List<PastMeeting> myPastMeetingList = new LinkedList<PastMeeting>();
	//
	//private Set<Contact> myContactSet = new TreeSet<Contact>();
	//Lists Contact objects for use in addNewContact and getContacts methods.
	private List<Contact> myContactList = new LinkedList<Contact>();

	public int addFutureMeeting(Set<Contact> contacts, Calendar date) {
		countfuture++;
		FutureMeeting myMeeting = new FutureMeetingImpl(countfuture, date, contacts);
		myFutureMeetingList.add(myMeeting);
		return countfuture;
	}

	public PastMeeting getPastMeeting(int id) {
		return myPastMeetingList.get(id);
	}

	public FutureMeeting getFutureMeeting(int id) {
		return myFutureMeetingList.get(id);
	}

	public Meeting getMeeting(int id) {
		return myMeetingList.get(id);
	}

	public List<Meeting> getFutureMeetingList(Contact contact) {
		List<Meeting> returnMeeting = new LinkedList<Meeting>();
		for (int i = 0; i < countfuture; i++) {
			Meeting myMeeting = myFutureMeetingList.get(i);
			Set<Contact> myContactSet = myMeeting.getContacts();
			if (myContactSet.contains(contact)) {
				returnMeeting.add(myMeeting);
			}
		}
		return returnMeeting;
	}

	public List<Meeting> getMeetingListOn(Calendar date) {
		List<Meeting> returnMeeting = new LinkedList<Meeting>();
		for (int i = 0; i < countfuture; i++) {
			Meeting x = myFutureMeetingList.get(i);
			Calendar y = x.getDate();
			if (y.equals(date)) {
				returnMeeting.add(x);
			}
		}
		for (int i = 0; i < countfuture; i++) {
			Meeting x = myPastMeetingList.get(i);
			Calendar y = x.getDate();
			if (y.equals(date)) {
				returnMeeting.add(x);
			}
		}
		return returnMeeting;
	}

	public List<PastMeeting> getPastMeetingListFor(Contact contact) {
		List<PastMeeting> returnMeeting = new LinkedList<PastMeeting>();
		for (int i = 0; i < countpast; i++) {
			PastMeeting myMeeting = myPastMeetingList.get(i);
			Set<Contact> myContactSet = myMeeting.getContacts();
			if (myContactSet.contains(contact)) {
				returnMeeting.add(myMeeting);
			}
		}
		return returnMeeting;
	}

	public void addNewPastMeeting(Set<Contact> contacts, Calendar date, String text) {
		countpast++;
		PastMeeting myPastMeeting = new PastMeetingImpl(countpast, date, contacts, text);
		myPastMeetingList.add(myPastMeeting);
	}

	public PastMeeting addMeetingNotes(int id, String text) {
		FutureMeeting myFM = this.getFutureMeeting(id);
		int mfID = myFM.getId();
		Set<Contact> mfContact = myFM.getContacts();
		Calendar mfDate = myFM.getDate();
		countpast++;
		PastMeeting myPM = new PastMeetingImpl(countpast, mfDate, mfContact, text);
		myPastMeetingList.add(myPM);
		countfuture--;
		myFutureMeetingList.remove(id);
		return myPM;
	}

	public int addNewContact(String name, String notes) {
		contactcount++;
		Contact myContact = new ContactImpl(contactcount, name, notes);
		myContactList.add(myContact);
		return contactcount;
	}

	public Set<Contact> getContacts(String name) {
		Set<Contact> returnCont = new TreeSet<Contact>();
		for (int i = 0; i < contactcount; i++) {
			Contact myCon = myContactList.get(i);
			String conName = myCon.getName();
			if (conName.equals(name)) {
					returnCont.add(myCon);
			}
		}
		return returnCont;
	}

	public Set<Contact> getContacts(int... ids) {
		Set<Contact> returnCont = new TreeSet<Contact>();
		for (int i = 0; i < contactcount; i++) {
			Contact myCon = myContactList.get(i);
			int myID = myCon.getId();
			for (int x = 0; x < ids.length; x++) {
				if (myID == ids[x]) {
					returnCont.add(myCon);
				}
			}
		}
		return returnCont;
	}

	public void flush(){
		String currentContactManager = "cm.txt";
		File file = new File(currentContactManager);
		PrintWriter out = null;
		try {
			out = new PrintWriter(file);
			out.write(currentContactManager);
		} catch (FileNotFoundException ex) { 
			System.out.println("Cannot write to file " + file + ".");
		} finally {
			out.close();
		}
	}

}