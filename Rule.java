package lab4;

public class Rule {

	private char input; //input for rule
	private String output; //rule's output
	
	public Rule(char input, String output) {
		this.input = input;
		this.output = output;
	}
	
	//returns input, a String object
	public char getInput() {
		return this.input;
	}
	
	//returns output. a String object
	public String getOutput() {
		return output;
	}
	
	
	
}
