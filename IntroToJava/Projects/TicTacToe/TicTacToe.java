import java.util.Scanner;

public class TicTacToe {
	
	private int[][] board;
	private boolean turn;
	private boolean external_start;
	private int turn_count;

	private Scanner user_input;
	private Player computer_player;
	private Player user_player;

	public TicTacToe() {
		this.board = new int[3][3];

		for(int row = 0 ; row < this.board.length ; row++) {
			for(int column = 0 ; column < this.board[0].length ; column++) {
				this.board[row][column] = 0;
			}
		}

		this.turn = false;
		this.turn_count = 0;
		this.user_input = new Scanner(System.in);
		this.computer_player = new RandomAI();
		this.user_player = new OtherAI();
		this.external_start = false;
	}

	public void play(boolean manual) {

		boolean game_continues = true;

		while(game_continues) {

			if(this.turn) {
				System.out.println("=============");
				System.out.println("Round #" + (this.turn_count / 2));
				System.out.println("=============");

				this.printBoard();

				if(manual) {
					boolean move_captured = false;
					int row = 0, column = 0;

					while(!move_captured) {
						System.out.println("What is your move?");
						System.out.print("Row: ");
						row = user_input.nextInt();
						System.out.print("Column: ");
						column = user_input.nextInt();

						if(this.isLegalMove(row, column)) {
							move_captured = true;
						} else {
							System.out.println("Illegal move: ("+row+","+column+")");
						}
					}

					this.board[row][column] = !this.turn ? 1 : 2;

				} else {
					boolean move_captured = false;
					int[] user_move = new int[2];

					user_move = user_player.move(this.board);
					this.board[user_move[0]][user_move[1]] = !this.turn ? 1 : 2;
				}
			} else {
				boolean move_captured = false;
				int[] computer_move = new int[2];

				computer_move = computer_player.move(this.board);
				this.board[computer_move[0]][computer_move[1]] = !this.turn ? 1 : 2;
			}

			int game_status = this.isDone();

			if(game_status != 0) {
				System.out.println("Player " + game_status + " wins!");
				game_continues = false;
			} else if(this.turn_count == 8) {
				System.out.println("Draw!");
				game_continues = false;
			}

			this.turn = !this.turn;
			this.turn_count++;
		}

		System.out.println("=============");
		System.out.println("FINAL BOARD");
		System.out.println("=============");

		this.printBoard();

		this.user_input.close();

	}

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

	private boolean isLegalMove(int row, int column) {
		return (row >= 0 && row < this.board.length && column >= 0 && column < this.board[0].length && this.board[row][column] == 0);
	}

	private int isDone() {
		String flat_board_p1 = "";
		String flat_board_p2 = "";
		int winner = 0;
		
		for(int row = 0 ; row < this.board.length ; row++) {
			for(int column = 0 ; column < this.board[0].length ; column++) {
				flat_board_p1 += (this.board[row][column] == 1) ? "1" : "0";
				flat_board_p2 += (this.board[row][column] == 2) ? "1" : "0"; 
			}
		}

		String[] winning_scenarios = {
			"111000000", "000111000", "000000111",
			"100010001", "001010100", "100100100",
			"010010010", "001001001"
		};

		for(int scenario = 0 ; scenario < winning_scenarios.length && winner == 0 ; scenario++) {
			boolean win1 = true, win2 = true;

			for(int index = 0 ; index < winning_scenarios[scenario].length() ; index++) {
				if(winning_scenarios[scenario].charAt(index) == '1') {
					if(flat_board_p1.charAt(index) != '1') win1 = false;
					if(flat_board_p2.charAt(index) != '1') win2 = false;
				}
			}

			if(win1) winner = 1;
			else if(win2) winner = 2;
		}

		return winner;
	}
}