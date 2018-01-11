package gov.nist.healthcare.hl7.mm.v2.domain;

public class Component {
	private int id;
	
	public Component(String id){
		this.id = Integer.parseInt(id);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString(){
		return id + "";  
	}
}
