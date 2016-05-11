package de.kreth.textumbruch.business;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TextUmbrecherTest {

	private TextUmbrecher brecher;
	
	@Before
	public void initTest() {
		brecher = new TextUmbrecher();
	}
	
	@Test
	public void testEmptyString() {
		String result = brecher.umbruch("", 0);
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	public void testLineBreak1Line(){
		String input = "Lore ipsum lore ipsum";

		String expected = "Lore ipsum lore ipsum";
		String result = brecher.umbruch(input, 100);
		assertEquals(expected, result);
	}

	@Test
	public void testLineBreak2Line(){
		String input = "Lore ipsum lore ipsum";

		String expected = "Lore ipsum\nlore ipsum";
		String result = brecher.umbruch(input, 12);
		assertEquals(expected, result);
	}
	
	@Test
	public void testLineBreak3Line(){
		String input = "Lore ipsum lore ipsum lore ipsum";

		String expected = "Lore ipsum\nlore ipsum\nlore ipsum";
		String result = brecher.umbruch(input, 12);
		assertEquals(expected, result);
	}
   
   @Test
   public void testBreakNoSpace() {

      String input = "LoreipsumLoreipsum";

      String expected = "Loreipsum\nLoreipsum";
      String result = brecher.umbruch(input, 9);
      assertEquals(expected, result);
   }

   @Test
   public void testBreakWithHyph() {

      String input = "Dies ist eine Abkürzung gewesen!";

      String expected = "Dies ist eine Abkür-\nzung gewesen!";
      String result = brecher.umbruch(input, 20);
      assertEquals(expected, result);
   }

   @Test
   public void testBreakWithHyphLastWordAndMore() {

      String input = "Dies ist eine Abkürzung! Nur eine.";

      String expected = "Dies ist eine Abkür-\nzung! Nur eine.";
      String result = brecher.umbruch(input, 20);
      assertEquals(expected, result);
   }

   @Test
   public void testBreakWithHyphLastWord() {

      String input = "Dies ist eine Abkürzung!";

      String expected = "Dies ist eine Abkür-\nzung!";
      String result = brecher.umbruch(input, 20);
      assertEquals(expected, result);
   }

   @Test
   public void testLineBreakWithEmptyLines() {
      String input = "\n\t\tint lineLength = Integer.parseInt(textFieldZeichenAnzahl.getText());\n\t\ttextAreaOutput.setText(umbrecher.umbruch(textAreaInput.getText(), lineLength));";
      String expected = "\n\t\tint lineLength = Integer.parseInt(textFieldZeichenAnzahl.getText());\n\t\ttextAreaOutput.setText(umbrecher.umbruch(textAreaInput.getText(), lineLength));";
      String result = brecher.umbruch(input, 85);
      assertEquals(expected, result);
   }
   
}
