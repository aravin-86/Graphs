package co.in.graph;

/**
 * @see <a href="https://leetcode.com/problems/word-search/">Word Search</a>
 */
public class WordSearch {

    private char[][] board;
    private int numOfRows;
    private int numOfCols;

    // Backtracking Algorithm
    // O(N * 3^L) Time, where N is the number of cells and L is the length of the word to be matched.
    // O(L) Space
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.numOfRows = board.length;
        this.numOfCols = board[0].length;

        for (int row = 0; row < numOfRows; row++) {
            for (int col = 0; col < numOfCols; col++) {
                if (backtrack(row, col, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean backtrack(int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row == numOfRows || col == numOfCols
                || board[row][col] != word.charAt(index)) {

            return false;
        }


        //mark the path before exploration
        board[row][col] = '#';

        boolean result = (backtrack(row - 1, col, word, index + 1) || backtrack(row + 1, col, word, index + 1)
                            || backtrack(row, col - 1, word, index + 1) || backtrack(row, col + 1, word, index + 1));

        board[row][col] = word.charAt(index);

        return result;
    }
}
