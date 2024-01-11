package programs;

import java.util.Scanner;

public class Access {

	public static void main(String[] args) {
		
		// set variable
		String password = "";
		int number = 0;
		int answer_num = 1847;
		String stop = "quit";
		
		
		Scanner sc = new Scanner (System.in);
		
		
		for (int i = 0; i < 3; i ++) {
			
			System.out.print("Enter password: ");
			
			password = sc.next();
			
			// if answer is quit, stop run the code
			if (password.equals(stop)) {
				
				break;
				
			// if password is not equal (do es not match number), print wrong credentials
			} else if (!password.equals("terps")) {
				
				System.out.print("Enter number: ");
				
				number = sc.nextInt();
				
				if (number != answer_num) {
					
					System.out.println("Wrong credentials");
					
				} else if (number == answer_num) {
					
					System.out.println("Wrong credentials");
					
				}
			// if the both password and number are correct, stop the loop
			} else {
				
				System.out.print("Enter number: ");
				
				number = sc.nextInt();
				
				if (number == answer_num) {
					
					break;
					
				} else {
					
					System.out.println("Wrong credentials");
					
				}
				
			}
		
		}		
		
			// if the both password and number are correct, print access granted, else, print access denied 
			if (password.equals("terps") && number == answer_num) {
				
				System.out.print("Access Granted");
				
			} else {
				
				System.out.print("Access Denied");
				
			}
			
			sc.close();
	}
	
}
