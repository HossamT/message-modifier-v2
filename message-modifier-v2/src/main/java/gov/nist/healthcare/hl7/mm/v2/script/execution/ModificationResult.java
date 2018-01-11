package gov.nist.healthcare.hl7.mm.v2.script.execution;

import java.util.List;

import org.immregistries.dqa.message_modifier.script.Issue;

public class ModificationResult {
	List<Issue> issues;
	boolean status;
	int numberOfExecutedCommands;
	String resultMessage;
	
	
	public ModificationResult(List<Issue> issues, boolean status, int numberOfExecutedCommands, String resultMessage) {
		super();
		this.issues = issues;
		this.status = status;
		this.numberOfExecutedCommands = numberOfExecutedCommands;
		this.resultMessage = resultMessage;
	}
	
	public List<Issue> getIssues() {
		return issues;
	}
	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getNumberOfExecutedCommands() {
		return numberOfExecutedCommands;
	}
	public void setNumberOfExecutedCommands(int numberOfExecutedCommands) {
		this.numberOfExecutedCommands = numberOfExecutedCommands;
	}
	public String getResultMessage() {
		return resultMessage;
	}
	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}
}
