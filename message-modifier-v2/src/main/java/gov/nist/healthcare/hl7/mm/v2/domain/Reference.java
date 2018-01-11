package gov.nist.healthcare.hl7.mm.v2.domain;

public class Reference {
	private HL7Path path;
	private HL7Path context;
	
	
	public Reference(HL7Path path, HL7Path context) {
		super();
		this.path = path;
		this.context = context;
	}
	
	public HL7Path getPath() {
		return path;
	}
	public void setPath(HL7Path path) {
		this.path = path;
	}
	public HL7Path getContext() {
		return context;
	}
	public void setContext(HL7Path context) {
		this.context = context;
	}
}
