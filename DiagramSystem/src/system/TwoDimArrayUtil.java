package system;

public class TwoDimArrayUtil {

	public static boolean isRagged​(char[][] array) {
		//get length of row and col
		int row = array.length;
		int col = array[0].length;
		//check if they are not rectangle
		for (int i = 0; i < row; i++) {
			if (array[i].length != col) {
				return true;
			} 
		}
		return false;
	}

	public static void rotateTopOneRow​(char[][] array) {
		if (isRagged​(array) == true || array == null){
			throw new IllegalArgumentException(); 
		}
		// temporary save array[0]
		char[] temp = array[0];
		//rotate the values
		for(int i = 0; i < array.length - 1; i++) {
			array[i] = array[i + 1];
		}
		//add temp on the last row
		array[array.length - 1] = temp;
	}

	public static void rotateLeftOneColumn​(char[][] array) {
		if (isRagged​(array) == true || array == null){
			throw new IllegalArgumentException(); 
		}
		
		//rotate the values
		for(int i = 0; i < array.length;i++) {
			char temp =	array[i][0];
			for(int j = 0; j < array[i].length - 1; j++) {
				array[i][j] = array[i][j + 1];
			} 	
			//add temp on the last col
			array[i][array[i].length - 1] = temp;
		}
	}

	public static char[][] appendTopBottom​(char[][] top, char[][] bottom) {
		//get total length
		int row = top.length + bottom.length;
		// add top on the new 2d array
		char[][] answer = new char[row][];
		for(int i = 0; i < top.length; i++) {
			answer[i] = top[i];
		}
		//add up the bottom on the previous 2d array
		int count = top.length;
		for(int i = 0; i < bottom.length; i++) {
			answer[count++] = bottom[i];
		}
		return answer;
	}

	public static char[][] appendLeftRight​(char[][] left, char[][] right) {
		// get a longer row
		int max = Math.max(left.length, right.length);
		char[][] array = new char[max][];
			//check size of the column
		for (int i = 0; i < max; i++) {
			int size = 0;
			if (i < left.length) {
				size += left[i].length;
			}
			if (i < right.length) {
				size += right[i].length;
			}
			
			array[i] = new char[size];
			int idx = 0;
			//add left on the new 2d array
			if (i < left.length) {
				for(int j = 0; j < left[i].length;j++) {
					array[i][j] = left[i][j];
					idx++;
				}
			}
			//add right on the existing new 2d array
			if (i < right.length) {
				for (int j = 0; j < right[i].length; j++) {
					array[i][idx] = right[i][j];
					idx++;
				}
			}
		}
		return array;
	}
}
