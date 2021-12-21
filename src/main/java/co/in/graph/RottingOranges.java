package co.in.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<int[]>();

        int numOfRows = grid.length;
        int numOfCols = grid[0].length;

        int freshOranges = 0;

        for (int row = 0; row < numOfRows; row++) {
            for (int col = 0; col < numOfCols; col++) {
                if (grid[row][col] == 2) {
                    queue.offer(new int[]{row, col});
                }

                if ((grid[row][col] == 1)) {
                    freshOranges++;
                }
            }
        }

        //Mark the first minute/round
        queue.offer(new int[]{-1, -1});

        int timestamp = -1;

        while (!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            int curRow = currentPos[0];
            int curCol = currentPos[1];

            if (curRow == -1) {
                timestamp++;

                if (!queue.isEmpty()) {
                    queue.offer(new int[]{-1, -1});
                }
            } else {
                List<int[]> neighbours = getNeighbours(curRow, curCol, numOfRows, numOfCols);

                for (int[] neighbour : neighbours) {
                    int row = neighbour[0];
                    int col = neighbour[1];

                    //Found fresh orange next to Rotten Orange
                    if (grid[row][col] == 1) {
                        //Rot Orange
                        grid[row][col] = 2;
                        freshOranges--;

                        queue.offer(new int[]{row, col});
                    }
                }

            }
        }

        return freshOranges == 0 ? timestamp : -1;
    }

    private List<int[]> getNeighbours(int row, int col, int numOfRows, int numOfCols) {
        List<int[]> neighbours = new ArrayList<int[]>();

        if (row - 1 >= 0) {
            neighbours.add(new int[]{row - 1, col});
        }

        if (row + 1 < numOfRows) {
            neighbours.add(new int[]{row + 1, col});
        }

        if (col - 1 >= 0) {
            neighbours.add(new int[]{row, col - 1});
        }

        if (col + 1 < numOfCols) {
            neighbours.add(new int[]{row, col + 1});
        }

        return neighbours;
    }

}
