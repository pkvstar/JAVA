public class fourteen {
    //? N Queens
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        solveNQueens(board, 0);
    }

    public static void solveNQueens(int[][] board, int col) {
        if (col == board.length) {
            printBoard(board);
            System.out.println(); // Separate solutions
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 1; // Place queen
                solveNQueens(board, col + 1); // Recurse to next column
                board[row][col] = 0; // Backtrack
            }
        }
    }

    public static boolean isSafe(int[][] board, int row, int col) {
        // Check this row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // Check upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1)
                return false;
        }

        // Check lower left diagonal
        for (int i = row, j = col; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1)
                return false;
        }

        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int val : row) {
                System.out.print(val == 1 ? "Q " : ". ");
            }
            System.out.println();
        }
    }
}
