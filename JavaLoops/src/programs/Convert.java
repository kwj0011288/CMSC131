package programs;

import java.util.Scanner;

public class Convert {

	public static void main(String[] args) {
		
		// set varaible
		int remainder = 0;
		String answer ="";
		
		//set scanner;
		Scanner sc = new Scanner (System.in);
		
		//get int value 
		System.out.print("Enter decimal number: ");
		int decimal = sc.nextInt();
	
		
		do {
			// get remainder for the answer
			remainder = decimal % 8;
			
			//to get the further remainder, need to find the value
			decimal = decimal / 8;
			
			// change int to string & return number on the answer
			answer += remainder;
			
		} while (decimal > 0);
		
		//reverse the number and print that out
		System.out.println("Octal value: " + Support.reverseString(answer));
		sc.close();
	}

}
