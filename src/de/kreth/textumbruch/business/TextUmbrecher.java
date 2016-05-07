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
		
		if (lastIndexOf >0 && lastIndexOf < lineLength) {
			output = input.substring(0, lastIndexOf);
			
			if(input.length()-lastIndexOf - lineLength < 0) {
				output += "\n" + input.substring(lastIndexOf + 1);
			} else {
				String substring = input.substring(lastIndexOf + 1);
				lastIndexOf = substring.lastIndexOf(" ", lineLength);
				output += "\n" + substring.substring(0, lastIndexOf);
				
				if(substring.length() - lastIndexOf - lineLength < 0){
					output += "\n" + substring.substring(lastIndexOf + 1);
				}
			}
		}
		return null;
	}

}
