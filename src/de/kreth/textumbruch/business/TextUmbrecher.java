package de.kreth.textumbruch.business;

public class TextUmbrecher {

	public String umbruch(String input, int lineLength) {
		String output = split(input, lineLength);
		
		return output;
	}

	private String split(String input, int lineLength) {
		if (input.length()<=lineLength)
			return input;
		
		String output;

		int lastIndexOf = input.lastIndexOf(" ", lineLength);

		output = input.substring(0, lastIndexOf);
		
		if(input.length()-lastIndexOf - lineLength < 0) {
			output += "\n" + input.substring(lastIndexOf + 1);
		} else {
			String substring = input.substring(lastIndexOf + 1);
			output += "\n" + split(substring, lineLength);
			
		}
		
		return output;
	}

}
