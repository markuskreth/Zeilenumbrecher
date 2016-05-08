package de.kreth.textumbruch.business;

public class TextUmbrecher {
   
   private StringBuilder output;
   
	public String umbruch(String input, int lineLength) {
	   
	   output = new StringBuilder(input.length()+10);
	   
		split(input, lineLength);
		
		return output.toString();
	}

	private void split(String input, int lineLength) {
		if (input.length()<=lineLength) {
		   output.append(input);
		   return;
		}

		int lastIndexOf = input.lastIndexOf(" ", lineLength);
		int nextStartIndex = lastIndexOf + 1;

		if (lastIndexOf <0) {
		   lastIndexOf = lineLength;
		   nextStartIndex = lastIndexOf;
		}
		
		output.append(input.substring(0, lastIndexOf)).append("\n");
		
		if(input.length()-lastIndexOf - lineLength < 0) {
			output.append(input.substring(nextStartIndex));
		} else {
		   String substring = input.substring(nextStartIndex);
		   split(substring, lineLength);
		}
		
	}

}
