public class MyContact implements Contact {
	
	private int id = 0;
	
	private String name = null;
	
	private String note = null;
	
	public MyContact(int id, String name, String note) {
		this.id = id;
		this.name = name;
		this.note = note;
	}
	
	public MyContact(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return 0;
	}
	
	public String getName(){
		return null;
	}
	
	public String getNotes(){
		return null;
	}
	
	public void addNotes(String note){}

}