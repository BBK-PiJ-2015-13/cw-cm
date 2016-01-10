public class ContactImpl implements Contact {
	
	private int id = 0;
	
	private String name = null;
	
	private String notes = "";
	
	public ContactImpl(int id, String name, String notes) {
		try {
			this.name = name;
		} catch (NullPointerException ex) {
			System.out.println("Invalid name!");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		try {
			this.id = id;
		} catch (IllegalArgumentException ex) {
			System.out.println("Invalid ID!");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		this.notes = notes;
	}
	
	public ContactImpl(int id, String name) {		
		try {
			this.id = id;
		} catch (IllegalArgumentException ex) {
			System.out.println("Invalid ID!");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		try {
			this.name = name;
		} catch (NullPointerException ex) {
			System.out.println("Invalid name!");
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
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
		this.notes += note;
	}

}