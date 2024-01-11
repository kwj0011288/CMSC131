package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import sysutilities.Name;

public class StudentTests {

	@Test
	public void test() {
		
		
		//constructor 1
		System.out.println("----Constructor Test 1----");
		Name name1 = new Name("Claudia", "I.", "Smith");
		System.out.println("Expected : " + "Smith,Claudia,I.");
		System.out.println("Answer : " + name1);

		//constructor 2
		System.out.println("----Constructor Test 2----");
		Name name2 = new Name("Rachel", "I.", "Green", '#');
		System.out.println("Expected : " + "Green#Rachel#I.");
		System.out.println("Answer : " + name2);

		//constructor 3
		System.out.println("----Constructor Test 3----");
		Name name3 = new Name("Wonjae", "L", "Kim");
		name3.setNickname("Jay");
		System.out.println("Expected : " + "Kim,Wonjae,L(Jay)");
		System.out.println("Answer : " + name3);

		//constructor 4 (default)
		System.out.println("----Default Constructor Test----");
		Name name4 = new Name();
		System.out.println("Expected : " + "NOLASTNAME#NOFIRSTNAME#NOMIDDLENAME");
		System.out.println("Answer : " + name4);
		
		System.out.println("----Equal method Test----");
		System.out.println("Expected : " + "false");
		System.out.println("Answer: " + name1.equals(name2));

		System.out.println("----compareTo method Test----");
		System.out.println("Expected : " + "false");
		System.out.println("Answer : " + (name1.compareTo(name2) < 0));
		
		System.out.println("----Uppercase Test----");
		System.out.println("Expected : " + "KIM,WONJAE,L");
		Name name5 = Name.normalize(name3, true);
		System.out.println("Answer : " + name5);
		
		System.out.println("----Lowercase Test----");
		System.out.println("Expected : " + "kim,wonjae,l");
		Name name6 = Name.normalize(name3, false);
		System.out.println("Answer : " + name6);
		
		System.out.println("----Number of the object----");
		System.out.println("Expected : " + "6");
		System.out.println("Answer :  " + Name.getNumberOfNameObjects());
	}

}
