package gov.nist.healthcare.hl7.mm.v2.script.execution;

import gov.nist.healthcare.hl7.mm.v2.domain.Command;
import gov.nist.healthcare.hl7.mm.v2.domain.CommandType;
import gov.nist.healthcare.hl7.mm.v2.domain.UseCommand;
import gov.nist.healthcare.hl7.mm.v2.exceptions.CommandExecutionException;

public class UseCommandExecutor implements CommandExecutor {

	public boolean handles(CommandType type) {
		return type == CommandType.USE;
	}

	public <T extends Command> void execute(ExecutionContext context, T command) throws CommandExecutionException {
		UseCommand useCommand = (UseCommand) command;
		context.getEnvironement().setValue(useCommand.getKey(), useCommand.getValue());
	}

}
