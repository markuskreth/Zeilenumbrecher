package de.kreth.textumbruch.business;

import org.apache.fop.hyphenation.*;

public class TextUmbrecher {
   
   private StringBuilder output;
   private Hyphenator h = new Hyphenator("de", null,3,4);
   
	public String umbruch(String input, int lineLength) {
	   
	   output = new StringBuilder(input.length()+10);
	   String[] split = input.split("\r?\n");
	   if(split.length == 1)
	      split(input, lineLength);
	   else {
	      int count = 0;
	      for (String s : split) {
	         count++;
	         split(s, lineLength);
	         if(count<split.length)
	            output.append("\n");
	      }
	   }
		
		return output.toString();
	}

	private void split(String input, int lineLength) {
		if (input.length()<=lineLength) {
		   output.append(input);
		   return;
		}

		int nextStartIndex = findSplitIndex(input, lineLength);
		
		if(input.length() - nextStartIndex - lineLength < 0) {
			output.append(input.substring(nextStartIndex));
		} else {
		   String substring = input.substring(nextStartIndex);
		   split(substring, lineLength);
		}
		
	}

   private int findSplitIndex(String input, int lineLength) {

      int lastIndexOf = input.lastIndexOf(" ", lineLength);
      int nextStartIndex = lastIndexOf + 1;

      if (lastIndexOf <0) {
         lastIndexOf = lineLength;
         nextStartIndex = lastIndexOf;
      }
      
      output.append(input.substring(0, lastIndexOf));
      
      nextStartIndex = checkHyphenation(nextStartIndex, input, lineLength);
      output.append("\n");
      
      return nextStartIndex;
   }

   private int checkHyphenation(int nextStartIndex, String input, int lineLength) {
      int endIndex = input.indexOf(" ", nextStartIndex);
      if (endIndex < 0) {
    	  endIndex = input.length() - 1;
      }
      if (endIndex >0) {

         String lastWord = input.substring(nextStartIndex, endIndex);
		Hyphenation hn = h.hyphenate(lastWord);
         
         if(hn != null) {

            int[] indices = hn.getHyphenationPoints();
            for (int i=indices.length-1; i>=0; i--) {
               if(nextStartIndex + indices[i] <= lineLength -1){
                  output.append(" ").append(input.substring(nextStartIndex, nextStartIndex + indices[i])).append("-");
                  return nextStartIndex + indices[i];
                  
               }
            }
         }
         
      } 
      
      return nextStartIndex;
   }

}
