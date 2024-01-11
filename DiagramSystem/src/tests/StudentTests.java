package tests;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import app.DrawingApp;
import system.CombineLeftRight;
import system.CombineTopBottom;
import system.Flag;
import system.HorizontalBars;
import system.TwoDimArrayUtil;
import system.VerticalBars;

public class StudentTests {

	@Test
	public void IsRaggedTest1() {
		char[][] array = {  {'A', 'A', 'A' }, 
							{'B', 'B', 'B', 'B' }, 
							{'C','C', 'C', 'C', 'C', 'C' } };

		boolean answer = TwoDimArrayUtil.isRagged​(array);

		assertEquals(true, answer);
	}

	@Test
	public void IsRaggedTest2() {
		char[][] array = {  {'A', 'A', 'A'}, 
							{'B', 'B', 'B'}, 
							{'C', 'C', 'C'} };

		boolean answer = TwoDimArrayUtil.isRagged​(array);

		assertEquals(false, answer);
	}

	@Test
	public void rotateTopOneRow​Test() {
		System.out.println("---------- rotateTopOneRow​Test ----------");

		char[][] array = {  {'A', 'A', 'A'}, 
							{'B', 'B', 'B'}, 
							{'C', 'C', 'C'} };

		char[][] answer = { {'B', 'B', 'B'}, 
							{'C', 'C', 'C'}, 
							{'A', 'A', 'A'} };
		TwoDimArrayUtil.rotateTopOneRow​(array);

		for (char[] ar: array) {
			for (char ar2 :ar) {
				System.out.print(ar2);
			}
			System.out.println("\n");
		}
		assertTrue(Arrays.deepEquals(array, answer));
	}

	@Test
	public void rotateLeftOneColumn​Test() {
		System.out.println("---------- rotateLeftOneColumn​Test​ ----------");
		char[][] array = {	{'A', 'B', 'C'}, 
							{'D', 'E', 'F'}, 
							{'G', 'H', 'I'} };

		char[][] answer = { {'B', 'C', 'A'}, 
							{'E', 'F', 'D'}, 
							{'H', 'I', 'G'} };

		TwoDimArrayUtil.rotateLeftOneColumn​(array);
		for (char[] ar: array) {
			for (char ar2 : ar) {
				System.out.print(ar2);
			}
			System.out.println("\n");
		}
		assertTrue(Arrays.deepEquals(array, answer));
	}

	@Test
	public void appendTopBottom​Test() {
		System.out.println("---------- appendTopBottom​​Test​ ----------");

		char[][] array = {	{'A', 'A', 'A', 'A', 'A'}, 
							{'B', 'B', 'B'}, 
							{'C', 'C', 'C', 'C', 'C' }};

		char[][] array2 = { {'D', 'D', 'D'}, 
							{'E', 'E', 'E'}, 
							{'F', 'F', 'F'}};

		char[][] answer = { {'A', 'A', 'A', 'A', 'A'}, 
							{'B', 'B', 'B'}, 
							{'C', 'C', 'C', 'C', 'C' },
							{'D', 'D', 'D'}, 
							{'E', 'E', 'E'}, 
							{'F', 'F', 'F'}};


		char[][] check = TwoDimArrayUtil.appendTopBottom​(array, array2);
		for (char[] ar1: check) {
			for (char ar2 : ar1) {
				System.out.print(ar2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(check, answer));
	}

	@Test
	public void appendLeftRightTest1() {
		System.out.println("---------- appendLeftRight​​​​Test1​ ----------");

		char[][] array = {  {'A', 'A', 'A', 'A', 'A'}, 
							{'B', 'B', 'B'}, 
							{'C', 'C', 'C', 'C', 'C' }};

		char[][] array2 = {{ 'D', 'D', 'D'}, 
							{'E', 'E', 'E', 'E', 'E'}, 
							{'F', 'F', 'F', 'F'}};

		char[][] answer = {{ 'A', 'A', 'A', 'A', 'A', 'D', 'D', 'D'}, 
							{'B', 'B', 'B','E', 'E', 'E', 'E', 'E'}, 
							{'C', 'C', 'C', 'C', 'C' ,'F', 'F', 'F', 'F'}};

		char[][] check = TwoDimArrayUtil.appendLeftRight​(array, array2);
		for (char[] ar1: check) {
			for (char ar2 : ar1) {
				System.out.print(ar2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(check, answer));
	}
	@Test
	public void appendLeftRightTest2() {
		System.out.println("---------- appendLeftRight​​​​Test2 ----------");


		char[][] array2 = { { 'G', 'H', 'A', 'B' }, 
							{ 'I', 'J', 'B' } 
							};

		char[][] array3 = { { 'M', 'N', 'W' }, 
							{ 'O', 'P' }, 
							{ 'Q' } 
							};

		char[][] answer = { { 'G', 'H', 'A', 'B', 'M', 'N', 'W' }, 
							{ 'I', 'J', 'B', 'O', 'P' } ,
							{ 'Q' } 
							};

		char[][] check = TwoDimArrayUtil.appendLeftRight​(array2, array3);
		for (char[] ar1: check) {
			for (char ar2 : ar1) {
				System.out.print(ar2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(check, answer));
	}
	@Test
	public void VerticalBarsNextAnimationStepTest() {
		System.out.println
		("---------- VerticalBarsNextAnimationStepTest​​ ----------");

		VerticalBars vBar = new VerticalBars(5, 6, 3 , 'R', 'G', 'B', 1);
		char[][] test = vBar.getBoard();

		char[][] og =  {{'R', 'R', 'G', 'G', 'B', 'B'},
						{'R', 'R', 'G', 'G', 'B', 'B'},
						{'R', 'R', 'G', 'G', 'B', 'B'},
						{'R', 'R', 'G', 'G', 'B', 'B'},
						{'R', 'R', 'G', 'G', 'B', 'B'}
						};


		char[][] answer = { {'R', 'G', 'G', 'B', 'B', 'R'},
							{'R', 'G', 'G', 'B', 'B', 'R'},
							{'R', 'G', 'G', 'B', 'B', 'R'},
							{'R', 'G', 'G', 'B', 'B', 'R'},
							{'R', 'G', 'G', 'B', 'B', 'R'}
							};

		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(vBar.getNumberCols()  == 6);
		assertTrue(vBar.getNumberRows()  == 5);

		for (int i = 0 ; i < 1; i++ ) {
			char [][]v = vBar.nextAnimationStep();
			for(int j = 0; j < v.length; j++) {
				System.out.println(Arrays.toString(v[j]));
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));

	}
	@Test
	public void HorizontalBarsNextAnimationStepTest() {
		System.out.println
		("---------- HorizontalBarsNextAnimationStepTest​​ ----------");

		HorizontalBars hBar = new HorizontalBars(9, 3, 3 ,'R', 'G', 'B', 1);
		char[][] test = hBar.getBoard();

		char[][] og =  {{'R', 'R', 'R'},
						{'R', 'R', 'R'},
						{'R', 'R', 'R'},
						{'G', 'G', 'G'},
						{'G', 'G', 'G'},
						{'G', 'G', 'G'},
						{'B', 'B', 'B'},
						{'B', 'B', 'B'},
						{'B', 'B', 'B'}
		};


		char[][] answer = {	{'R', 'R', 'R'},
							{'R', 'R', 'R'},
							{'G', 'G', 'G'},
							{'G', 'G', 'G'},
							{'G', 'G', 'G'},
							{'B', 'B', 'B'},
							{'B', 'B', 'B'},
							{'B', 'B', 'B'},
							{'R', 'R', 'R'}
							};

		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(hBar.getNumberCols()  == 3);
		assertTrue(hBar.getNumberRows()  == 9);

		for (int i = 0 ; i < 1; i++ ) {
			char[][] v = hBar.nextAnimationStep();
			for(int j = 0; j < v.length; j++) {
				System.out.println(Arrays.toString(v[j]));
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}

	@Test
	public void FlagTest1() {

		System.out.println
		("---------- FlagTest​​1 ----------");

		Flag flag = new Flag(3, 'R', 'G', 'B', 1);
		char[][] test = flag.getBoard();

		
		char[][] og = {{'R','G','G','G','G','G','G','G','G','G',
						'G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G'}};
		
		char[][] answer = 
				{{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G'}, 
				};

		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(flag.getNumberCols() == 15);
		assertTrue(flag.getNumberRows() == 6);
	
		for (char[] value: flag.getBoard()) {
			for (char value2 : value) {
				System.out.print(value2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}
	@Test
	public void FlagTest2() {

		System.out.println
		("---------- FlagTest​​2 ----------");

		Flag flag = new Flag(3, 'R', 'G', 'B', 2);
		char[][] test = flag.getBoard();
		
		char[][] og = {{'R','G','G','G','G','G','G','G','G','G',
						'G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G'}};
		
		char[][] answer = 
				{{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','R','G','G','G','G','G','G','G','G','G','G','G','G'},
				{'R','R','B','B','B','B','B','B','B','B','B','B','B','B','B'},
				{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G'}, 
				{'R','G','G','G','G','G','G','G','G','G','G','G','G','G','G'}};

		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(flag.getNumberCols() == 15);
		assertTrue(flag.getNumberRows() == 6);

		
		for (char[] value: flag.nextAnimationStep()) {
			for (char value2 : value) {
				System.out.print(value2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}
	
	@Test
	public void CombineLeftRightTest1() {

		System.out.println
		("---------- CombineLeftRightTest1​ ----------");
		HorizontalBars left = new HorizontalBars(3, 6, 3 ,'R', 'G', 'B', 1);
		VerticalBars right = new VerticalBars(3, 6, 3 , 'R', 'G', 'B', 1);

		CombineLeftRight combineLeftRight = 
										new CombineLeftRight(left, right, 1);
		char[][] test = combineLeftRight.getBoard();

		
		char[][] og = { {'R','R','R','R','R','R','R','R','G','G','B','B'},
						{'G','G','G','G','G','G','R','R','G','G','B','B'},
						{'B','B','B','B','B','B','R','R','G','G','B','B'}};
		
		char[][] answer = { {'R','R','R','R','R','R','R','G','G','B','B','R'},
							{'G','G','G','G','G','R','R','G','G','B','B','G'},
							{'B','B','B','B','B','R','R','G','G','B','B','B'}};
				
		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(combineLeftRight.getNumberCols() == 12);
		assertTrue(combineLeftRight.getNumberRows() == 3);

		
		for (char[] value: combineLeftRight.nextAnimationStep()) {
			for (char value2 : value) {
				System.out.print(value2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}
	
	@Test
	public void CombineLeftRightTest2() {

		System.out.println
		("---------- CombineLeftRightTest2​ ----------");
		HorizontalBars left = new HorizontalBars(3, 6, 3 ,'R', 'G', 'B', 1);
		VerticalBars right = new VerticalBars(3, 6, 3 , 'R', 'G', 'B', 1);

		CombineLeftRight combineLeftRight = 
										new CombineLeftRight(left, right, 2);
		char[][] test = combineLeftRight.getBoard();

		
		char[][] og = { {'R','R','R','R','R','R','R','R','G','G','B','B'},
						{'G','G','G','G','G','G','R','R','G','G','B','B'},
						{'B','B','B','B','B','B','R','R','G','G','B','B'}};
		
		char[][] answer = {{'G','G','G','G','G','G','R','R','G','G','B','B'},
							{'B','B','B','B','B','B','R','R','G','G','B','B'},
							{'R','R','R','R','R','R','R','R','G','G','B','B'}};
				
		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(combineLeftRight.getNumberCols() == 12);
		assertTrue(combineLeftRight.getNumberRows() == 3);

		
		for (char[] value: combineLeftRight.nextAnimationStep()) {
			for (char value2 : value) {
				System.out.print(value2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}
	
	@Test
	public void CombineTopBottomTest1() {

		System.out.println
		("---------- CombineTopBottomTest1​ ----------");
		HorizontalBars top = new HorizontalBars(3, 6, 3 ,'R', 'G', 'B', 1);
		VerticalBars bottom = new VerticalBars(3, 6, 3 , 'R', 'G', 'B', 1);

		CombineTopBottom CombineTopBottom = 
										new CombineTopBottom(top, bottom, 1);
		char[][] test = CombineTopBottom.getBoard();

		
		char[][] og = { {'R','R','R','R','R','R'},
						{'G','G','G','G','G','G'},
						{'B','B','B','B','B','B'},
						{'R','R','G','G','B','B'},
						{'R','R','G','G','B','B'},
						{'R','R','G','G','B','B'}};
		
		char[][] answer = { {'R','R','R','R','R','R'},
							{'G','G','G','G','G','G'},
							{'B','B','B','B','B','B'},
							{'R','G','G','B','B','R'},
							{'R','G','G','B','B','R'},
							{'R','G','G','B','B','R'}};
				
		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(CombineTopBottom.getNumberCols() == 6);
		assertTrue(CombineTopBottom.getNumberRows() == 6);

		
		for (char[] value: CombineTopBottom.nextAnimationStep()) {
			for (char value2 : value) {
				System.out.print(value2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}
	
	@Test
	public void CombineTopBottomTest2() {

		System.out.println
		("---------- CombineTopBottomTest2​ ----------");
		HorizontalBars top = new HorizontalBars(3, 6, 3 ,'R', 'G', 'B', 1);
		VerticalBars bottom = new VerticalBars(3, 6, 3 , 'R', 'G', 'B', 1);

		CombineTopBottom CombineTopBottom = 
										new CombineTopBottom(top, bottom, 2);
		char[][] test = CombineTopBottom.getBoard();

		
		char[][] og = { {'R','R','R','R','R','R'},
						{'G','G','G','G','G','G'},
						{'B','B','B','B','B','B'},
						{'R','R','G','G','B','B'},
						{'R','R','G','G','B','B'},
						{'R','R','G','G','B','B'}};
		
		char[][] answer = { {'G','G','G','G','G','G'},
							{'B','B','B','B','B','B'},
							{'R','R','G','G','B','B'},
							{'R','R','G','G','B','B'},
							{'R','R','G','G','B','B'},
							{'R','R','R','R','R','R'}};
				
		assertTrue(Arrays.deepEquals(test, og));
		assertTrue(CombineTopBottom.getNumberCols() == 6);
		assertTrue(CombineTopBottom.getNumberRows() == 6);

		
		for (char[] value: CombineTopBottom.nextAnimationStep()) {
			for (char value2 : value){
				System.out.print(value2);
			}
			System.out.println();
		}
		assertTrue(Arrays.deepEquals(test, answer));
	}
	
}

