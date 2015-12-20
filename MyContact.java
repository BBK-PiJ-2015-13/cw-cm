public class MyContact implements Contact {
	
	private int id = 0;
	
	private String name = null;
	
	private String notes = "";
	
	public MyContact(int id, String name, String notes) {
		this.id = id;
		this.name = name;
		this.notes = notes;
	}
	
	public MyContact(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getNotes(){
		return this.notes;
	}
	
	public void addNotes(String note){
		this.notes = note;
	}

}