package de.kreth.textumbruch.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import de.kreth.textumbruch.business.TextUmbrecher;

public class Umbreche {

	public static void main(String[] args) throws FileNotFoundException {
		Umbreche um = new Umbreche();
		um.start(args);
	}

	void start(String[] args) throws FileNotFoundException {

		if (args.length < 2)
			showHelp();
		else {
			File f = new File(args[0]);
			if (f.exists() && args[1].matches("\\d*")) {
				int lineCount = Integer.parseInt(args[1]);
				TextUmbrecher brecher = new TextUmbrecher();
				Scanner scanner = new Scanner(f);
				getOut().println(brecher.umbruch(scanner.useDelimiter("\\Z").next(), lineCount));
				scanner.close();
			} else
				showHelp();
		}
	}

	PrintStream getOut() {
		return System.out;
	}

	private void showHelp() {
		PrintStream out = getOut();
		out.println("Benutzung: " + Umbreche.class.getSimpleName() + " <DateiPfad> [Zeichenzahl]");
		out.println("Beispiel: " + Umbreche.class.getSimpleName() + " C:\\textdatei.txt 25");
	}

}
