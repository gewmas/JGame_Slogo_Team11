package model.parser;

import java.util.List;

public class DefaultParser extends Parser {
	
	public DefaultParser() {
		super();
	}

	public String parse(List<String> commandInput) {
		// {"sum", "5", "sum", "8", "9"}
		
		if(commandInput.get(0).equals("sum")) {
			Expression exp1 = new SumExpression(commandInput);
		}
		
		return "22";
	}
	
	
}
