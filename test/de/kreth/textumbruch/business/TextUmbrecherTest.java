package de.kreth.textumbruch.business;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextUmbrecherTest {

	@Test
	public void testEmptyString() {
		TextUmbrecher brecher = new TextUmbrecher();
		String result = brecher.umbruch("", 0);
		assertNotNull(result);
		assertTrue(result.isEmpty());
	}

	@Test
	public void testLineBreak1Line(){
		String input = "Lore ipsum lore ipsum";

		TextUmbrecher brecher = new TextUmbrecher();
		String expected = "Lore ipsum lore ipsum";
		String result = brecher.umbruch(input, 100);
		assertEquals(expected, result);
	}

	@Test
	public void testLineBreak2Line(){
		String input = "Lore ipsum lore ipsum";

		TextUmbrecher brecher = new TextUmbrecher();
		String expected = "Lore ipsum\nlore ipsum";
		String result = brecher.umbruch(input, 12);
		assertEquals(expected, result);
	}
	
	@Test
	public void testLineBreak3Line(){
		String input = "Lore ipsum lore ipsum lore ipsum";

		TextUmbrecher brecher = new TextUmbrecher();
		String expected = "Lore ipsum\nlore ipsum\nlore ipsum";
		String result = brecher.umbruch(input, 12);
		assertEquals(expected, result);
	}
}
