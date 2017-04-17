package sudoku_algorithm_challenge;


public class SudokuChecker
{
	static boolean[ ] checkRowArray;
	static boolean[ ] checkColumnArray;

	static int sudokuSize = 9;

	public static void main(String[ ] args)
	{
		int[ ][ ] correctInput = { { 2, 9, 6, 3, 1, 8, 5, 7, 4 },
				{ 5, 8, 4, 9, 7, 2, 6, 1, 3 }, { 7, 1, 3, 6, 4, 5, 2, 8, 9 },
				{ 6, 2, 5, 8, 9, 7, 3, 4, 1 }, { 9, 3, 1, 4, 2, 6, 8, 5, 7 },
				{ 4, 7, 8, 5, 3, 1, 9, 2, 6 }, { 1, 6, 7, 2, 5, 3, 4, 9, 8 },
				{ 8, 5, 9, 7, 6, 4, 1, 3, 2 }, { 3, 4, 2, 1, 8, 9, 7, 6, 5 } };

		int[ ][ ] wrongDuplicateInput = { { 2, 9, 6, 3, 2, 8, 5, 7, 4 },
				{ 5, 8, 4, 9, 7, 2, 6, 1, 3 }, { 7, 1, 3, 6, 4, 5, 2, 8, 9 },
				{ 6, 2, 5, 8, 9, 7, 3, 4, 1 }, { 9, 3, 1, 4, 2, 6, 8, 5, 7 },
				{ 4, 7, 8, 5, 3, 1, 9, 2, 6 }, { 1, 6, 7, 2, 5, 3, 4, 9, 8 },
				{ 8, 5, 9, 7, 6, 4, 1, 3, 2 }, { 3, 4, 2, 1, 8, 9, 7, 6, 5 } };

		int[ ][ ] wrongExtraCharInput = { { 2, 9, 6, 3, 2, 8, 5, 7, 4 },
				{ 5, 8, 4, 9, 7, 2, 6, 1, 3 }, { 7, 1, 3, 6, 4, 5, 2, 8, 9 },
				{ 6, 2, 5, 8, 9, 7, 3, 4, 1 }, { 9, 3, 1, 4, 2, 6, 8, 5, 7 },
				{ 4, 7, 8, 5, 0, 1, 9, 2, 6 }, { 1, 6, 7, 2, 5, 3, 4, 9, 8 },
				{ 8, 5, 9, 7, 6, 4, 1, 3, 2 }, { 3, 4, 2, 1, 8, 9, 7, 6, 5 } };
		
		int[ ][ ] wrongColumDupInput = { { 2, 9, 6, 3, 1, 8, 5, 7, 4 },
				{ 5, 8, 4, 9, 7, 2, 6, 1, 3 }, { 2, 1, 3, 6, 4, 5, 2, 8, 9 },
				{ 6, 2, 5, 8, 9, 7, 3, 4, 1 }, { 9, 3, 1, 4, 2, 6, 8, 5, 7 },
				{ 4, 7, 8, 5, 3, 1, 9, 2, 6 }, { 1, 6, 7, 2, 5, 3, 4, 9, 8 },
				{ 8, 5, 9, 7, 6, 4, 1, 3, 2 }, { 3, 4, 2, 1, 8, 9, 7, 6, 5 } };
		
		int[ ][ ] wrongColumIndexInput = { { 2, 9, 6, 3, 1, 8, 5, 7, 4 },
				{ 5, 8, 4, 9, 7, 2, 6, 1, 3 }, { 7, 17, 3, 6, 4, 5, 2, 8, 9 },
				{ 6, 2, 5, 8, 9, 7, 3, 4, 1 }, { 9, 3, 1, 4, 2, 6, 8, 5, 7 },
				{ 0, 7, 8, 5, 3, 1, 9, 2, 6 }, { 1, 6, 7, 2, 5, 3, 4, 9, 8 },
				{ 8, 5, 9, 7, 6, 4, 1, 3, 2 }, { 3, 4, 2, 1, 8, 9, 7, 6, 5 } };
		
		System.out.println( validate( correctInput ) );
		System.out.println( validate( wrongDuplicateInput ) );
		System.out.println( validate( wrongExtraCharInput ) );
		System.out.println(validate(wrongColumIndexInput));
		System.out.println(validate(wrongColumDupInput));

	}

	public static boolean validate(int[ ][ ] input)
	{
		//iterate through rows & collumns 
		for(int i = 0; i < sudokuSize; i++){
			checkRowArray = new boolean[sudokuSize];
			checkColumnArray = new boolean[sudokuSize];
			for(int j = 0; j < sudokuSize; j++){
				
				if(!checkValid(input[i][j], checkRowArray)){
					return false;
				}
				if(!checkValid(input[j][i], checkColumnArray))
				{
					return false;
				}
			}
		}	
		
		return true;
	}

	private static boolean checkValid(int input, boolean[ ] arrayCheck)
	{

		if( input < 1 || input > 9 )
		{
			return false;
		}

		if( arrayCheck[ input - 1 ] == true )
		{
			return false;
		}
		arrayCheck[ input - 1 ] = true;

		return true;
	}
	
	

}
