package de.kreth.textumbruch.ui;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UmbrecheTest {

	
	private static File testFile;

	@BeforeClass
	public static void createTestfile() throws IOException {
		testFile = new File("teststring.txt");
		FileWriter out = new FileWriter(testFile);
		out.write("012345678901234567890123456789");
		out.close();
	}
	
	@AfterClass
	public static void deleteTestfile() {
		testFile.delete();
	}

	private Umbreche umbrecher;
	private ByteArrayOutputStream text;
	
	@Before
	public void initTestUmbrecher() {
		text = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(text);
		umbrecher = new Umbreche() {
			@Override
			PrintStream getOut() {
				return out;
			}
		};
	}
	
	@Test
	public void testUmbruch() throws FileNotFoundException {
		umbrecher.start(new String[] {testFile.getName(), "10"});
		String output = text.toString();
		assertEquals("0123456789\n0123456789\n0123456789\n", output);
	}
	
	@Test
	public void testHelpout() throws FileNotFoundException {
		umbrecher.start(new String[] {testFile.getName()});
		String output = text.toString();
		assertTrue(output.contains(umbrecher.getClass().getSimpleName()));
		assertTrue(output.contains("Benutzung"));
		assertTrue(output.contains("Beispiel"));
	}

}
