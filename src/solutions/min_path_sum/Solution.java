package solutions.min_path_sum;

public class Solution {
    protected static int minPathSum(int[][] grid) {
        
        int shortestPathSum = findMinPathSum(grid, 0, 0, 0);
        
        return  shortestPathSum;
    }

    private static int findMinPathSum(int[][] grid, int row, int col, int currentSum) {
        
        int[][] pathsGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < pathsGrid.length; i++) {
            for (int j = 0; j < pathsGrid[i].length; j++) {
                pathsGrid[i][j] = Integer.MAX_VALUE;
            }
        }

        // iterate through the grid
        for (int i = row; i < grid.length; i++) {
            int currentRowSum;
            if(i == 0) {
                currentRowSum = 0;
            } else {
                currentRowSum = pathsGrid[i - 1][0];
            }
            for (int j = col; j < grid[i].length; j++) {
                if(i == 0) {
                    currentRowSum += grid[i][j];
                } else {
                    currentRowSum = Math.min(currentRowSum, pathsGrid[i - 1][j]) + grid[i][j];
                }
                pathsGrid[i][j] = currentRowSum;
            }
        }
        /* */
        for (int[] displayRow : pathsGrid) {
            for (int value : displayRow) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        // return the minimum path sum
        return pathsGrid[grid.length - 1][grid[0].length - 1];
    }
}
