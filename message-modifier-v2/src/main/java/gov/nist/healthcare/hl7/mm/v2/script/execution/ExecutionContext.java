package gov.nist.healthcare.hl7.mm.v2.script.execution;

import java.util.ArrayList;
import java.util.List;

import org.immregistries.dqa.message_modifier.script.Issue;

import gov.nist.healthcare.hl7.mm.v2.domain.MMScript;

public class ExecutionContext {
	MMScript script;
	String message;
	ExecutionEnvironment environement;
	int executedCommands = 0;
	List<Issue> issues = new ArrayList<Issue>();
	
	public MMScript getScript() {
		return script;
	}
	public void setScript(MMScript script) {
		this.script = script;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExecutionEnvironment getEnvironement() {
		return environement;
	}
	public void setEnvironement(ExecutionEnvironment environement) {
		this.environement = environement;
	}
	public List<Issue> getIssues() {
		return issues;
	}
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	public int getExecutedCommands() {
		return executedCommands;
	}
	public void setExecutedCommands(int executedCommands) {
		this.executedCommands = executedCommands;
	}
	public void incExec(){
		this.executedCommands++;
	}
	
}
