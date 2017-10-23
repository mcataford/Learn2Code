/*
*	Author: Marc Cataford (and you!)
*
*	This file contains your implementation of your Tic Tac Toe AI.
*/

public class OtherAI extends Player {

	/*
	*	Produces a move that can be applied on the game board. This method
	*	must be implemented by any AI.
	*
	*	@param board 2D array representing the current state of the board.
	*
	*	@return An integer array representing the [y,x] position of the move.
	*/
	
	public int[] move(int[][] board) {
		/*
		*	This method will generate a move that will then be used as your AI's move
		*	during the game. Simply write out your code here and make sure that the 
		*	final move you wish to submit is stored in the "move" array variable
		*	following the convention [row, column]!
		*
		*	You can look at the other AI (RandomAI.java) to see a naive example.
		*
		*	You should play a few games manually before attempting to distill
		*	your strategy into code!
		*
		*	If your move is judged invalid (see TicTacToe.java, isLegalMove()),
		*	another move will be asked from your AI.
		*/

		//Container for your move, format: [row, column]
		int[] move = new int[2];

		//Your code goes here!

		//Gives back the move to the game.
		return move;
	}
}