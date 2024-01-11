package sysutilities;

import javax.swing.JOptionPane;

public class PhotoProcessingSys {

	private  String name;
	private double balance;
	
	//start cost with 1 dollars
	private int cost = 1;

	private Address address;

	StringBuffer transactions = new StringBuffer();

	public PhotoProcessingSys(String name, String street,String city, String state, String zipCode) {

		this.name = name;
		// throw exception if address is invalid
		try {
			if (city != "" && state != "" & zipCode != "") {
				address = new Address(street, city, state, zipCode);
			} else {
				address = new Address();
			}
		} catch (IllegalArgumentException e) {

		}
	}

	
	public PhotoProcessingSys() { //default constructor

		name = "NONAME";
		address = new Address();

	}

	public String toString() { 

		return "Customer Name: " + name + "Customer Address: " + address.toString()
		+ "Balance: " + getBalance();

	}
	// a method that everything about image processing
	public String imageTransaction (String imageName, String task, String taskOptions, boolean graphicalMode) {

		if (graphicalMode) {

			PictureManager.graphicalModeOn();

		} else {

			PictureManager.graphicalModeOff();
		}
		// if task is dispaly display picture
		if (task.equals("display")) {
			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
				
			}
			String displayPic = PictureManager.displayPicture(imageName);
			transactions = transactions.append("Transaction #" + cost+ ": " + displayPic);
			cost++;
			this.balance++;
			return displayPic;
			// if task is clear, display clear screen
		} else if (task.equals("clear")){

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
				
			}

			String clear = PictureManager.clearScreen();
			transactions = transactions.append("Transaction #" + cost+ ": " + clear);
			cost++;
			this.balance++;
			return clear;
			// display last one
		} else if (task.equals("displaylast")) {

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
				
			}

			String last = PictureManager.displayLastPicture();
			transactions = transactions.append("Transaction #" + cost+ ": " + last);
			cost++;
			this.balance++;
			return last;
			//display black and white but no posterize
		} else if (task.equals("blackandwhite")) {

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
				
			}

			String blackAndWhite = PictureManager.displayPictureBlackWhitePosterize(imageName, true, false );
			transactions = transactions.append("Transaction #" + cost+ ": " + blackAndWhite);
			cost++;
			this.balance++;
			return blackAndWhite;
			// no black and white but posterize
		} else if (task.equals("posterize")) {

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}

			String posterize = PictureManager.displayPictureBlackWhitePosterize(imageName, false, true );
			transactions = transactions.append("Transaction #" + cost+ ": " + posterize);
			cost++;
			this.balance++;
			return posterize;
			// do both black and white and posterize
		} else if (task.equals("blackandwhiteposterize")) {

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
				
			}

			String blackAndWhitePosterize = PictureManager.displayPictureBlackWhitePosterize(imageName, true, true );
			transactions = transactions.append("Transaction #" + cost+ ": " + blackAndWhitePosterize);
			cost++;
			this.balance++;
			return blackAndWhitePosterize;

		} else if (task.equals("selectcolors")) {
			boolean red, green, blue; 

			red = false;
			green = false;
			blue = false;
			// get character of taskOption so that get the right color
			for (int i = 0; i < taskOptions.length(); i++ ) {

				if (taskOptions.charAt(i) == 'r' ||taskOptions.charAt(i) == 'R')  {

					red = true;

				} else if (taskOptions.charAt(i) == 'g'  ||taskOptions.charAt(i) == 'G' ) {

					green = true;

				} else if (taskOptions.charAt(i) == 'b'  ||taskOptions.charAt(i) == 'B' ) {

					blue = true;

				}


			}

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}
			String selectcolors = PictureManager.displayPictureSelectRedGreenBlue(imageName, red, green, blue );

			transactions = transactions.append("Transaction #" + cost+ ": " + selectcolors);
			cost++;
			this.balance = this.balance + 2; // +2 dollars on the select color
			return selectcolors;

		} else {

			if (graphicalMode) {
				JOptionPane.showMessageDialog(null, "Continue");
			}

			transactions = transactions.append("Transaction #" + cost+ ": Invalid photoProcessing option");
			cost++;

			return "Invalid photoProcessing option";
		}
	}
	// change stringbuffer to string and add string literal in front of it
	public String getTransactions() {
		return "Image Transactions \n" + transactions.toString();
	}


	public double getBalance() {
		return balance;
	}


}

