package de.kreth.textumbruch.ui;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TextUmbruchJFrameTest {

	private TextUmbruchJFrame frame;

	@Before
	public void setUp() throws Exception {
		frame = new TextUmbruchJFrame();
	}

	@After
	public void shutdown() {
		frame.setVisible(false);
		frame.dispose();
	}
	
	@Test
	public void testInitStatus() {
		assertTrue(frame.textAreaOutput.getText().isEmpty());
		String zeichenzahl = frame.textFieldZeichenAnzahl.getText();
		assertEquals("35", zeichenzahl);
	}
	
	@Test
	public void testUmbruch() throws InterruptedException {
		assertTrue(frame.textAreaOutput.getText().isEmpty());
		frame.textFieldZeichenAnzahl.setText("10");
		frame.textAreaInput.setText("012345678901234567890123456789");
		frame.btnUmbreche.doClick();

		assertEquals("0123456789\n0123456789\n0123456789", frame.textAreaOutput.getText());
	}

}
