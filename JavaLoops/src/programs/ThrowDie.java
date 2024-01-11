package programs;

import java.util.Random;
import java.util.Scanner;

public class ThrowDie {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//dice 1 ~ 6
		String dice_one = "...\n.0.\n...";
		String dice_two = "0..\n...\n..0";
		String dice_three = "0..\n.0.\n..0";
		String dice_four = "0.0 \n...\n0.0";
		String dice_five = "0.0\n.0.\n0.0";
		String dice_six = "0.0\n0.0\n0.0";
		
		//Ask condition
		System.out.print("How many times to throw a die?: ");
		int throwing = sc.nextInt();
		
		//set random dice number
		Random number = new Random(throwing);
		int random_num = 0;
		
		for (int i = 1; i < throwing+1; i++) {
			
			//print throw #n
			System.out.println("Throw #" + i);
			
			//randomly assign the number
			random_num = number.nextInt(6);
			
			//print dice
			if (random_num == 0) {
				
				System.out.println(dice_one);
				
			} else if (random_num == 1) {
				
				System.out.println(dice_two);
			
			} else if (random_num == 2) {
				
				System.out.println(dice_three);
			
			} else if (random_num == 3) {
				
				System.out.println(dice_four);
			
			} else if (random_num == 4) {
				
				System.out.println(dice_five);
			
			} else if (random_num == 5) {
				
				System.out.println(dice_six);
			
			}
			
		}
		sc.close();
	}

}
