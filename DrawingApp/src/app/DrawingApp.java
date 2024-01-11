package app;

import java.util.Random;

public class DrawingApp {

	public static void main(String[] args) {

		System.out.print(isValidColor('R'));
		System.out.println();
		System.out.print(getRectangle (6,9,'*'));
		System.out.println();
		System.out.print(getHorizontalBars(16, 10, 4, 'R', 'G', 'B'));
		System.out.println();
		System.out.println();
		System.out.print(getFlag(2,'R','.','B'));
		System.out.println();
		System.out.println();
		System.out.print(getFlag(8,'R','.','Y'));
		System.out.println();
		System.out.println();
		System.out.print(getVerticalBars(10, 12, 3, 'R', 'G', 'B'));
		System.out.println();

	}

	public static boolean isValidColor(char color) {

		if (color == 'R' || color == 'G' || color == 'B' 
				|| color == 'Y' || color == '*' || color == '.') {

			return true;

		} else {

			return false;
		}

	}

	public static String getRectangle(int maxRows, int maxCols, char symbol) {

		String answer = "";
		// if the rows and cols are less than 1, print nothing
		if (maxRows < 1 || maxCols < 1) {

			return null;

		} else {
			// make a rectangle
			for (int i = 0; i < maxRows; i++) {
				for (int j = 0; j < maxCols; j++) {

					answer += symbol;

				}
				//getting rid of space at the end
				if (i != maxRows - 1) {
					answer += "\n";
				}

			}
			return answer;

		}

	}

	public static char getRandomColor(Random random) {

		int number = random.nextInt(6);

		if (number == 0) {

			return 'R';

		} else if (number == 1) {

			return 'G';

		} else if (number == 2) {

			return 'B';

		} else if (number == 3) {

			return 'Y';

		} else if (number == 4) {

			return '*';

		} else {

			return '.';

		}

	}

	public static String getHorizontalBars (int maxRows, int maxCols, int bars, 
			char color1, char color2, char color3) {

		String result = "";
		int bar_num = maxRows / bars;

		// if maxRow is less then 1, or the colors are not match,  return nothing
		if (maxRows < 1 || !isValidColor(color1) 
				|| !isValidColor(color2) || !isValidColor(color3)) {

			result = null;

		} else {
			// check how many bars that will make
			if (maxRows % bars != 0) {

				maxRows -= maxRows / bars;

			}
			// start to make a square
			for (int i = 0; i < maxRows; i++) {
				int rows = i / bar_num;
				//write the if statement to make sure 
				//if remainder is 0, print first color bar again
				for (int j = 0; j < maxCols; j++) { 
					if (rows % 3 == 0 && rows < bars) { 

						result += color1;

					} else if (rows % 3 == 1 && rows < bars) {

						result += color2;

					} else if (rows % 3 == 2 && rows < bars) {

						result += color3;
					}
				}
				// delete the space at the end of the bars
				if (i != maxRows - 1) {
					result += "\n";

				}

			}

		}
		return result;
	}

	public static String getFlag(int size, char color1,
			char color2, char color3) {

		String result = "";

		if (size == 2) {
			return null;
		}

		//	System.out.print(getFlag(10,'R','.','Y'));
		// draw first half of triangle
		for (int i = 1; i <= size; i++) {
			for (int j = 1; j <= i; j++) {
				if (size == 2) {

				}
				result += color1;
			}
			// for the first and the last time, return color2
			if (i == 1 || i == size) {
				for (int h = 1; h <= size * 5 - i; h++) {

					result += color2;
				}
				result += "\n";
				// return color3 for rest of them
			} else {
				for (int k = 1; k <= size * 5 - i; k++) {
					result += color3;
				}
				result += "\n";
			}
		}
		// draw second half of triangle
		for (int i = 0; i < size; i++) {
			for (int j = 1; j <= size - i; j++) {
				result += color1;
			}
			//// for the first and the last time, return color2
			if (i == 0 || i == size - 1) {
				for (int h = 1; h <= size * 5 - (size - i); h++) {
					result += color2;
				}
				// return color3 for rest of them
			} else {
				for (int k = 1; k <= size * 5 - (size - i); k++) {
					result += color3;
				}
			}
			if (i != size - 1) {
				result += "\n";
			}
		}
		return result;
	}

	public static String getVerticalBars(int maxRows, int maxCols, 
			int bars, char color1, char color2, char color3) {

		String result = "";
		int col_num = maxCols / bars;

		// if maxRow is less then 1, or the colors are not match,  return nothing
		if (col_num < 1 || maxRows < 1 || !isValidColor(color1) 
				|| !isValidColor(color2) || !isValidColor(color3)) {

			return null;
		} else {

			if (maxCols % bars != 0) {

				maxCols -= maxCols / bars;

			}
			int cols = 0;
			// start to make a square
			for (int i = 1; i <= maxRows; i++) {
				for (int j = 0; j <= maxCols; j++) {


					if (j / col_num != 0) {
						cols = j / col_num;
					} else {
						cols = 0;
					}

					//write the if statement to make sure 
					//if remainder is 0, print first color bar again

					if (cols % 3 == 0 && cols < bars) { 
						result += color1;


					} else if (cols % 3 == 1 && cols < bars) {

						result += color2;

					} else if (cols % 3 == 2 && cols < bars) {

						result += color3;
					}
				}
				// delete the space at the end of the bars
				if (i != maxRows ) {
					result += "\n";

				}

			}

		}
		return result;
	}
}