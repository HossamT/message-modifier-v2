package gov.nist.healthcare.hl7.mm.v2.script.execution;

import gov.nist.healthcare.hl7.mm.v2.domain.Command;
import gov.nist.healthcare.hl7.mm.v2.domain.CommandType;
import gov.nist.healthcare.hl7.mm.v2.exceptions.CommandExecutionException;

public interface CommandExecutor {
	
	public boolean handles(CommandType type);
	public <T extends Command> void execute(ExecutionContext context, T command) throws CommandExecutionException;
	
}
