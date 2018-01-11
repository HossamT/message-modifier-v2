package gov.nist.healthcare.hl7.mm.v2.script.execution;

import java.util.ArrayList;
import java.util.List;

import gov.nist.healthcare.hl7.mm.v2.domain.Command;
import gov.nist.healthcare.hl7.mm.v2.domain.MMScript;
import gov.nist.healthcare.hl7.mm.v2.exceptions.CommandExecutionException;
import gov.nist.healthcare.hl7.mm.v2.generated.ParseException;
import gov.nist.healthcare.hl7.mm.v2.generated.Parser;
import gov.nist.healthcare.hl7.mm.v2.generated.TokenMgrError;

public class MessageModifierService {
	
	List<CommandExecutor> commandExecutors = new ArrayList<CommandExecutor>();
	
	public MessageModifierService(){
		this.commandExecutors.add(new UseCommandExecutor());
	}
	
	public ModificationResult modify(String msg, String scr){
		ExecutionContext context = new ExecutionContext();
		MMScript script = this.parseScript(context, scr);
		context.setMessage(msg);

		if(script != null){
			context.setScript(script);
			for(Command c : script.getCommands()){
				try {
					this.execute(context, c);
				} 
				catch (CommandExecutionException e) {
					context.issues.add(e.getIssue());
				}
			}
		}

		return new ModificationResult(context.getIssues(), script != null, context.getExecutedCommands(), context.getMessage());		
	}
	
	private MMScript parseScript(ExecutionContext context, String scr){
		try {
			return Parser.parse(scr);
		} catch (ParseException e) {
			
			//TODO ADD PARSE ISSUE TO CONTEXT
			
			return null;
		} catch (TokenMgrError e) {
			
			//TODO ADD PARSE ISSUE TO CONTEXT
			
			return null;
		}
	}
	
	private void execute(ExecutionContext context, Command c) throws CommandExecutionException{
		for(CommandExecutor exec : commandExecutors){
			if(exec.handles(c.getType())){
				exec.execute(context, c);
				context.incExec();
			}
		}
	}
}
