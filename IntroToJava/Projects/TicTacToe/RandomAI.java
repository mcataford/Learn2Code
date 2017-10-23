/*
*	Author: Marc Cataford
*
*	Basic AI that plays the board randomly. Each move made is verified before being returned.
*/

public class RandomAI extends Player {

	/*
	*	Chooses a random available mode and verifies its validity before returning it.
	*
	*	@param board 2D array representing the current state of the board.
	*
	*	@return An integer array representing the [y,x] position of the move.
	*/

	public int[] move(int[][] board) {
		int row = 0, column = 0;
		boolean is_empty = false;

		//While the cell that is being targetted is NOT empty.
		while(!is_empty) {

			//Generate a random y,x couple.

			row = (int) (Math.random() * board.length);
			column = (int) (Math.random() * board[0].length);

			//Test if the cell is empty.

			is_empty = (board[row][column] == 0);
		}

		//If the cell is empty, then it's our chosen move.
		
		int[] move = {row, column};

		return move;
	}
}