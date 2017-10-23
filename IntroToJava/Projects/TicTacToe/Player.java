/*
*	Author: Marc Cataford
*
*	This class is only present to provide a basic player model.
*/

public abstract class Player {

	/*
	*	Produces a move that can be applied on the game board. This method
	*	must be implemented by any AI.
	*
	*	@param board 2D array representing the current state of the board.
	*
	*	@return An integer array representing the [y,x] position of the move.
	*/
	
	public abstract int[] move(int[][] board);
}