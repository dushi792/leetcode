public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i-1 < 0 && j-1 < 0)
                    continue;
                if (i-1 < 0)
                    grid[i][j] += grid[i][j-1];
                else if (j-1 < 0)
                    grid[i][j] += grid[i-1][j];
                else
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);
            }
        }
        return grid[m-1][n-1];
    }
}