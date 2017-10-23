/*
*	A game of Tic Tac Toe with framework for game AI.
*
*	Author: Marc Cataford
*
*	This is an implementation for a game of Tic Tac Toe.
*	Read the accompanying README.md file to know more about how you can use it!
*/

import java.util.Scanner;

public class TicTacToe {
	
	private int[][] board;						//The 3x3 game grid.
	private boolean turn;							//Flag to indicate whose turn it is.
	private boolean external_start;		//Flag to determine who starts.
	private int turn_count;						//Counter for the number of turns (2x per round)

	private Scanner user_input;				//Collector for user input if manual mode.
	private Player computer_player;		//Player objects.
	private Player user_player;

	/*
	*	Prepares the game state; initializes the game board to empties, the two player AIs and the turn count.
	*/

	public TicTacToe() {

		//Initialize the board and set its default state.

		this.board = new int[3][3];

		for(int row = 0 ; row < this.board.length ; row++) {
			for(int column = 0 ; column < this.board[0].length ; column++) {
				this.board[row][column] = 0;
			}
		}

		//Initialize the game variables.

		this.turn = false;
		this.turn_count = 0;
		this.user_input = new Scanner(System.in);
		this.computer_player = new RandomAI();
		this.user_player = new OtherAI();
		this.external_start = false;
	}

	/*
	*	Executes a single turn (half a round) and produces on-screen output. The turn flag 
	* will decide who gets to play. This method is the main game method.
	*
	*	@param manual Flag to determine whether the user plays manually or using its chosen AI.
	*/

	public void play(boolean manual) {

		//By default, the game is set to continue. This flag will be used to stop the game later.
		boolean game_continues = true;

		while(game_continues) {

			//If turn is true, then the user plays.
			if(this.turn) {

				//Print out the report header.
				System.out.println("=============");
				System.out.println("Round #" + (this.turn_count / 2));
				System.out.println("=============");

				//Print out the board for visual inspection.
				this.printBoard();

				//If the player chose to play manually...
				if(manual) {
					boolean move_captured = false;
					int row = 0, column = 0;

					//As long as a valid move isn't captured, prompt for a move.
					while(!move_captured) {
						System.out.println("What is your move?");

						System.out.print("Row: ");
						row = user_input.nextInt();

						System.out.print("Column: ");
						column = user_input.nextInt();

						//Once a move has been entered, it is only kept if it is valid.
						if(this.isLegalMove(row, column)) {
							move_captured = true;
						} else {
							System.out.println("Illegal move: ("+row+","+column+")");
						}
					}

					//The board is updated to reflect the move.
					this.board[row][column] = 2;

				} else {
					//If manual was not enabled, then we are using the user's AI.

					boolean move_captured = false;
					int[] user_move = new int[2];

					//Again, we capture the AI's move.
					while(!move_captured) {
						user_move = user_player.move(this.board);

						//If it is valid, we update the board.
						if(this.isLegalMove(user_move[0], user_move[1])) {
							this.board[user_move[0]][user_move[1]] = 2;
						} else {
							System.out.println("Illegal move: ("+user_move[0]+","+user_move[1]+")");
						}

					}

				}
			} else {
				//If it's the system's turn, the computer's AI makes a move always assumed to be valid.
				boolean move_captured = false;
				int[] computer_move = new int[2];

				computer_move = computer_player.move(this.board);
				this.board[computer_move[0]][computer_move[1]] = 1;
			}

			//Check if the game can continue (if we have a winner)
			int game_status = this.isDone();

			//If the game status is not 0, then we have a winner (1 or 2)
			if(game_status != 0) {
				System.out.println("Player " + game_status + " wins!");
				game_continues = false;
			//Else, we only interrupt the game if all the cells have been filled, in which case it's a draw.
			} else if(this.turn_count == 8) {
				System.out.println("Draw!");
				game_continues = false;
			}

			//We proceed to the next turn.
			this.turn = !this.turn;
			this.turn_count++;
		}

		//Once the game is over, we print the final board.
		System.out.println("=============");
		System.out.println("FINAL BOARD");
		System.out.println("=============");

		this.printBoard();

		//Since user input is no longer needed, we free up the resources.
		this.user_input.close();

	}

	/*
	*	Displays the board on the screen; the cells with 1 count for O and the cells with 2, for X.
	*/

	private void printBoard() {
		System.out.println("  0  1  2");

		for(int row = 0 ; row < this.board.length ; row++) {
			System.out.print(row);

			for(int column = 0 ; column < this.board[0].length ; column++) {
				String out = " ";
				if(this.board[row][column] == 1) {
					out = "X";
				} else if(this.board[row][column] == 2) {
					out = "O";
				}

				System.out.print(" " + out + " ");
			}

			System.out.print("\n\n");
		}

		System.out.print("\n");
	}

	/*
	*	Verifies the validity of a move based on the following criteria:
	*		- Is the row/column within bounds?
	*		- Is the cell targeted already occupied?
	*
	*	@param row Row index.
	*	@param column Column index.
	*
	*	@return Boolean value representing whether the move is valid or not.
	*/

	private boolean isLegalMove(int row, int column) {
		return (row >= 0 && row < this.board.length && column >= 0 && column < this.board[0].length && this.board[row][column] == 0);
	}

	/*
	*	Verifies if the game has a winner already. This is done by comparing the current board to a series
	*	of winning patterns. If there is any match, the game ends.
	*
	*	@return Integer representing the game status (0 for no winner, 1 or 2 for a winner).
	*/

	private int isDone() {

		//First, we "flatten" the board so that we only have to deal with a unidimensional string.

		String flat_board_p1 = "";
		String flat_board_p2 = "";
		int winner = 0;
		
		// We create two "flattened boards", one for each player. The flat boards contain only the moves made by the player.

		for(int row = 0 ; row < this.board.length ; row++) {
			for(int column = 0 ; column < this.board[0].length ; column++) {
				flat_board_p1 += (this.board[row][column] == 1) ? "1" : "0";
				flat_board_p2 += (this.board[row][column] == 2) ? "1" : "0"; 
			}
		}

		//These are all the winning patterns. They are obtained by putting all the rows next to each other.

		String[] winning_scenarios = {
			"111000000", "000111000", "000000111",
			"100010001", "001010100", "100100100",
			"010010010", "001001001"
		};

		//We iterate over all the winning patterns and check if any of the flat boards match the patterns of 1s.

		for(int scenario = 0 ; scenario < winning_scenarios.length && winner == 0 ; scenario++) {
			boolean win1 = true, win2 = true;

			for(int index = 0 ; index < winning_scenarios[scenario].length() ; index++) {
				if(winning_scenarios[scenario].charAt(index) == '1') {
					//If there is any mismatch between 1s, then the flat board cannot be a match for the pattern.

					if(flat_board_p1.charAt(index) != '1') win1 = false;
					if(flat_board_p2.charAt(index) != '1') win2 = false;
				}
			}

			//If either flat boards passed that test, we have a winner.
			
			if(win1) winner = 1;
			else if(win2) winner = 2;
		}

		return winner;
	}
}