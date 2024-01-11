package system;

import app.DrawingApp;
import gui.BoardCell;

public class HorizontalBars implements Diagram {
	
	int animationType;
	char [][] board;
	private int maxRows, maxCols;
	
	public HorizontalBars(int maxRows, int maxCols, int bars, char color1,
			char color2, char color3, int animationType) {

		this.animationType = animationType;
		this.board = BoardCell.getCharArray(DrawingApp.getHorizontalBars
				(maxRows, maxCols, bars, color1, color2, color3));
		this.maxRows = maxRows;
		this.maxCols = maxCols;
	}
	public char[][] getBoard() {
		return board;
	}
	public char[][] nextAnimationStep() {
		if (animationType == 1) {
			TwoDimArrayUtil.rotateTopOneRow​(board); 
		}
		return board;
	}
	public int getNumberRows() {
		return maxRows;
	}
	public int getNumberCols() {
		return maxCols;
	}
}
