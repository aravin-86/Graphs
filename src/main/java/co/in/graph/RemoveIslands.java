package co.in.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @see <a href="https://www.algoexpert.io/questions/Remove%20Islands">Remove Islands</a>
 */
public class RemoveIslands {

    public int[][] removeIslands(int[][] matrix) {

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                boolean rowInBorder = (row == 0 || row == matrix.length - 1);
                boolean colInBorder = (col == 0 || col == matrix[row].length - 1);
                boolean isBorder = rowInBorder || colInBorder;

                if(!isBorder) {
                    continue;
                }

                if(matrix[row][col] != 1) {
                    continue;
                }

                changeOnesConnectedToBorderToTwos(matrix, row, col);
            }
        }

        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[row].length; col++) {
                if(matrix[row][col] == 2) {
                    matrix[row][col] = 1;
                } else if(matrix[row][col] == 1) {
                    matrix[row][col] = 0;
                }
            }
        }

        return matrix;
    }

    private void changeOnesConnectedToBorderToTwos(int[][] matrix, int startRow, int startCol) {
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{startRow, startCol});

        while(!stack.isEmpty()) {
            int[] currentPos = stack.pop();
            int currentRow = currentPos[0];
            int currentCol = currentPos[1];

            matrix[currentRow][currentCol] = 2;

            List<int[]> neighbours = getNeighbours(matrix, currentRow, currentCol);
            for(int[] neighbour: neighbours) {
                int row = neighbour[0];
                int col = neighbour[1];

                if(matrix[row][col] != 1) {
                    continue;
                }

                stack.push(neighbour);
            }
        }
    }

    private List<int[]> getNeighbours(int[][] matrix, int row, int col) {
        int numOfRows = matrix.length;
        int numOfCols = matrix[row].length;

        List<int[]> neighbours = new ArrayList<int[]>();

        if(row - 1 >= 0) { // UP
            neighbours.add(new int[]{row - 1, col});
        }

        if(row + 1 < numOfRows) { //DOWN
            neighbours.add(new int[]{row + 1, col});
        }

        if(col - 1 >= 0) { //LEFT
            neighbours.add(new int[]{row, col - 1});
        }

        if(col + 1 < numOfCols) { //RIGHT
            neighbours.add(new int[]{row, col + 1});
        }

        return neighbours;
    }
}
