package gov.nist.healthcare.hl7.mm.v2.domain;

import java.util.List;

public class CallCommand extends Command {

	private String name;
	private List<Arg> args;
	
	
	public CallCommand(String name, List<Arg> args) {
		super(CommandType.CALL);
		this.name = name;
		this.args = args;
	}

}
