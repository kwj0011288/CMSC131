package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysutilities.Address;
import sysutilities.PhotoProcessingSys;

public class StudentTests {

	/* If you set to true images will be displayed when you ran the tests */
	public static final boolean GRAPHICAL_MODE_FLAG = false;

	@Test
	public void test1() {
		String answer = "";
		String expectedAnswer = "8134 Java St. Silver Spring VA 21567";

		Address address1 = new Address("8134 Java St.", "Silver Spring", "VA", "21567");
		answer += address1;


		assertEquals(expectedAnswer, answer);
	}

	@Test
	public void test2() {
		String answer = "";
		String expectedAnswer = "Customer Name: JohnCustomer Address: 8134 Java St. Silver Spring VA 21567Balance: 0.0";

		PhotoProcessingSys photoProcessingSys1 = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys1;

		assertEquals(expectedAnswer, answer);
	}

	@Test
	public void test3() {
		/* display */
		String answer = "";
		String expectedAnswer = "Display umcp1.jpg";

		PhotoProcessingSys photoProcessingSys2 = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys2.imageTransaction("umcp1.jpg", "display", null, false);
		answer = answer.trim();

		assertEquals(expectedAnswer, answer);
	}

	@Test
	public void test4() {
		/* clear */
		String answer = "";
		String expectedAnswer = "clearScreen";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");
		answer += photoProcessingSys.imageTransaction(null, "clear", null, false);

		answer = answer.trim();

		System.out.println(answer);
		assertTrue(expectedAnswer.equals(answer) );
	}


	@Test
	public void test6() {
		/* black and white */
		String answer = "";
		String expectedAnswer = "displayPictureBlackWhitePosterize: umcp1.jpg, truefalse";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");

		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "blackandwhite", null, false);
		answer = answer.trim();


		assertEquals(expectedAnswer, answer);
	}

	@Test
	public void test7() {
		/* posterize */
		String answer = "";
		String expectedAnswer = "displayPictureBlackWhitePosterize: umcp1.jpg, falsetrue";

		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");

		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "posterize", null, false);
		answer = answer.trim();

		assertEquals(expectedAnswer, answer);
	}

	@Test
	public void test8() {
		/* black and white and posterize */
		String answer = "";
		String expectedAnswer = "displayPictureBlackWhitePosterize: umcp1.jpg, truetrue";
		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");

		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "blackandwhiteposterize", null, false);
		answer = answer.trim();

		assertEquals(expectedAnswer, answer);
	}

	@Test
	public void test9() {
		/* select colors */
		String answer = "";
		String expectedAnswer = "displayPictureSelectRedGreenBlue: umcp1.jpg, truetruefalse\n"
				+ "Image Transactions \n"
				+ "Transaction #1: displayPictureSelectRedGreenBlue: umcp1.jpg, truetruefalse\n"
				+ "2.0";
		PhotoProcessingSys photoProcessingSys = new PhotoProcessingSys("John", "8134 Java St.", "Silver Spring", "VA", "21567");

		answer += photoProcessingSys.imageTransaction("umcp1.jpg", "selectcolors", "rG", false);
		answer += photoProcessingSys.getTransactions();
		answer += photoProcessingSys.getBalance();
		answer = answer.trim();

		System.out.println(answer);
		assertEquals(expectedAnswer, answer);
	}
	

}