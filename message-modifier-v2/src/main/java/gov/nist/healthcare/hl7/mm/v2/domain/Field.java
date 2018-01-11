package gov.nist.healthcare.hl7.mm.v2.domain;

public class Field {
	private int id;
	private int instance = 0;
	
	
	public Field(String id, String instance) {
		super();
		this.id = Integer.parseInt(id);
		this.instance = Integer.parseInt(instance);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getInstance() {
		return instance;
	}

	public void setInstance(int instance) {
		this.instance = instance;
	}

	public String toString(){
		return id + ( instance != 0 ? "[" + instance + "]"  : "");  
	}
}
