public class RandomAI extends Player {
	public int[] move(int[][] board) {
		int row = 0, column = 0;
		boolean is_empty = false;

		while(!is_empty) {
			row = (int) (Math.random() * board.length);
			column = (int) (Math.random() * board[0].length);

			is_empty = (board[row][column] == 0);
		}

		int[] move = {row, column};

		return move;
	}
}