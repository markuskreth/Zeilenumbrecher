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
		int nextStartIndex = lastIndexOf + 1;

		if (lastIndexOf <0) {
		   lastIndexOf = lineLength;
		   nextStartIndex = lastIndexOf;
		}
		
		output = input.substring(0, lastIndexOf);
		
		if(input.length()-lastIndexOf - lineLength < 0) {
			output += "\n" + input.substring(nextStartIndex);
		} else {
			String substring = input.substring(nextStartIndex);
			output += "\n" + split(substring, lineLength);
			
		}
		
		return output;
	}

}
