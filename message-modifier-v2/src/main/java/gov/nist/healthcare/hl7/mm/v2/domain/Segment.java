package gov.nist.healthcare.hl7.mm.v2.domain;

public class Segment {
	
	private String id;
	private int instance = 0;
	
	
	public Segment(String id, String instance) {
		super();
		this.id = id;
		this.instance = Integer.parseInt(instance);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
