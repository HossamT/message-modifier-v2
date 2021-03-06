package gov.nist.healthcare.hl7.mm.v2.test.syntax;

import static org.junit.Assert.*;

import org.junit.Test;

import gov.nist.healthcare.hl7.mm.v2.domain.AssignmentCommand;
import gov.nist.healthcare.hl7.mm.v2.domain.ConstantValue;
import gov.nist.healthcare.hl7.mm.v2.domain.MMScript;
import gov.nist.healthcare.hl7.mm.v2.domain.Reference;
import gov.nist.healthcare.hl7.mm.v2.domain.ReferenceValue;
import gov.nist.healthcare.hl7.mm.v2.domain.UseCommand;
import gov.nist.healthcare.hl7.mm.v2.domain.Value;
import gov.nist.healthcare.hl7.mm.v2.generated.ParseException;
import gov.nist.healthcare.hl7.mm.v2.generated.Parser;
import gov.nist.healthcare.hl7.mm.v2.generated.TokenMgrError;

public class ParserTest {
	
	@Test
	public void useContext() throws ParseException, TokenMgrError {
		MMScript mmScript = Parser.parse("use context::Immunization;");
		assert(mmScript.getCommands().size() == 1);
		assert(mmScript.getCommands().get(0) instanceof UseCommand);
		assert(((UseCommand) mmScript.getCommands().get(0)).getKey().equals("context"));
		assert(((UseCommand) mmScript.getCommands().get(0)).getValue().equals("Immunization"));
	}
	
	@Test
	public void assignmentConstantValue() throws ParseException, TokenMgrError {
		MMScript mmScript = Parser.parse("PID-5=\"\";");
		assert(mmScript.getCommands().size() == 1);
		assert(mmScript.getCommands().get(0) instanceof AssignmentCommand);
		
		Reference ref = ((AssignmentCommand) mmScript.getCommands().get(0)).getReference();
		assert(ref.getPath().getSegment().getId().equals("PID"));
		assert(ref.getPath().getField().getId() == 5);
		assert(ref.getPath().toString().equals("PID-5"));
		
		Value value = ((AssignmentCommand) mmScript.getCommands().get(0)).getValue();
		assert(value instanceof ConstantValue);
		assert(((ConstantValue) value).getConstant().equals("\"\""));
	}
	
	@Test
	public void assignmentReferenceValue() throws ParseException, TokenMgrError {
		MMScript mmScript = Parser.parse("PID-5.2 = $PID-5.1;");
		assert(mmScript.getCommands().size() == 1);
		assert(mmScript.getCommands().get(0) instanceof AssignmentCommand);
		
		Reference ref = ((AssignmentCommand) mmScript.getCommands().get(0)).getReference();
		assert(ref.getPath().getSegment().getId().equals("PID"));
		assert(ref.getPath().getField().getId() == 5);
		assert(ref.getPath().getComponent().getId() == 2);
		assert(ref.getPath().toString().equals("PID-5.2"));
		
		Value value = ((AssignmentCommand) mmScript.getCommands().get(0)).getValue();
		assert(value instanceof ReferenceValue);
		
		Reference refValue = ((ReferenceValue) value).getReference();
		assert(refValue.getPath().getSegment().getId().equals("PID"));
		assert(refValue.getPath().getField().getId() == 5);
		assert(refValue.getPath().getComponent().getId() == 1);
		assert(refValue.getPath().toString().equals("PID-5.1"));
	}

}
