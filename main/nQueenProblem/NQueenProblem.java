package nQueenProblem;

class NQueenProblem {
	static int n = 16;
	static int[][] board = new int[n][n];

	public static void main(String[] args) {
		System.out.println(placeQueen(0));
		displayBoard();
	}

	public static boolean isSafe(int i0, int j0) {
		// cheching for the row
		for (int j = j0; j >= 0; j--) {
			if (board[i0][j] == 1)
				return false;
		}
		int i = i0, j = j0;
		// checking for upper diagonal
		while (i >= 0 && j >= 0) {
			if (board[i][j] == 1)
				return false;
			i--;
			j--;
		}
		i = i0;
		j = j0;
		// checking for lower diagonal
		while (i < n && j >= 0) {
			if (board[i][j] == 1)
				return false;
			i++;
			j--;
		}
		return true;
	}

	public static int placeQueen(int x) {
		int solved = 0;
		if (x == n)
			return 1;
		for (int i = 0; i < n; i++) {
			if (board[i][x] == 0) {
				if (isSafe(i, x)) {
					board[i][x] = 1;
					solved = placeQueen(x + 1);
					if (solved == 1)
						return 1;
					else
						board[i][x] = 0;
				}
			}
		}
		return 0;
	}

	public static void displayBoard() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}
	}
}