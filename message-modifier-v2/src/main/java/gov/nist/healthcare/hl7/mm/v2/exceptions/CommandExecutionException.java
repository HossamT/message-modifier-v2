package gov.nist.healthcare.hl7.mm.v2.exceptions;

import org.immregistries.dqa.message_modifier.script.Issue;

public class CommandExecutionException extends Exception {
	private Issue issue;

	
	public CommandExecutionException(Issue issue) {
		super();
		this.issue = issue;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	
}
