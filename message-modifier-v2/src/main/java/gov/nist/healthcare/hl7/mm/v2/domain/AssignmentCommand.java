package gov.nist.healthcare.hl7.mm.v2.domain;

public class AssignmentCommand extends Command {
	Reference reference;
	Value value;
	
	
	public AssignmentCommand(Reference reference, Value value) {
		super(CommandType.ASSIGNMENT);
		this.reference = reference;
		this.value = value;
	}
	
	public Reference getReference() {
		return reference;
	}
	public void setReference(Reference reference) {
		this.reference = reference;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}
	
	
	
}
