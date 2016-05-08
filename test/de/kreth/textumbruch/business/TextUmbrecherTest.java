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
	public void testLineBreakWithEmptyLines() {
		String input = "\n\t\tint lineLength = Integer.parseInt(textFieldZeichenAnzahl.getText());\n\t\ttextAreaOutput.setText(umbrecher.umbruch(textAreaInput.getText(), lineLength));";
		String expected = "\n\t\tint lineLength = Integer.parseInt(textFieldZeichenAnzahl.getText());\n\t\ttextAreaOutput.setText(umbrecher.umbruch(textAreaInput.getText(), lineLength));";
		String resutl = brecher.umbruch(input, 70);
		assertEquals(expected, resutl);
	}
}
