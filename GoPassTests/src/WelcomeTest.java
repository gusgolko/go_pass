package src;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

public class WelcomeTest {

	@Test
	public void testPrintMessage() {

		ByteArrayOutputStream outStr = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outStr));
		
		Welcome welcome = new Welcome();
		welcome.printMessage();
		
		String w1 = "\n**************************************";
		String w2 = "\n********* Welcome to GoPass! *********";
		String w3 = "\n**************************************\n";
		String w4 = "\nGoPass generates strong passwords so you don't have to!";
		String w5 = "\n+ 8 characters in length";
		String w6 = "\n+ Mixed case";
		String w7 = "\n+ Alphanumeric";
		String w8 = "\n+ Special symbols\n\n";
		String expectedOut = w1 + w2 + w3 + w4 + w5 + w6 + w7 + w8;
		
		assertEquals(expectedOut, outStr.toString());
		
	}

}
