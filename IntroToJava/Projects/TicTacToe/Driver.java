/*
*	A game of Tic Tac Toe with framework for game AI.
*
*	Author: Marc Cataford
*
*	This file runs the game.
*/

public class Driver {
	public static void main(String[] args) {

		/*
		*	The first parameter decides if you play manually or not.
		*	The second parameter decides if you play first or not.
		*
		*	Before letting your AI play, make sure to write your code in OtherAI.java!
		*/

		TicTacToe game = new TicTacToe(true, true);

		game.play();
	}
}