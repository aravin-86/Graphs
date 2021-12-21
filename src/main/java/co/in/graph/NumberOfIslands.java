package co.in.graph;

public class NumberOfIslands {

    private int numOfRows;
    private int numOfCols;

    // O(M*N) Time, O(M*N) Space, where M is number of row and N is number of columns.
    public int numIslands(char[][] grid) {
        numOfRows = grid.length;
        numOfCols = grid[0].length;
        int numberOfIslands = 0;

        for(int row=0; row < numOfRows; row++) {
            for(int col=0; col < numOfCols; col++) {

                if(grid[row][col] == '1') {
                    numberOfIslands++;
                    dfs(grid, row, col);
                }
            }
        }

        return numberOfIslands;

    }

    private void dfs(char[][] grid, int row, int col) {

        if(row < 0 || col < 0 || row >= numOfRows || col >= numOfCols || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);

    }
}
