public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] table = new int[m][n];
        
        table[0][0] = (obstacleGrid[0][0] == 0 ? 1:0);
        
        for (int i = 1; i < n; i++) {
			// 要有两层括号
            table[0][i] = ((obstacleGrid[0][i] == 0 && table[0][i-1] != 0)? 1:0);
        }
        
        for (int j = 1; j < m; j++) {
			// 要有两层括号
            table[j][0] = ((obstacleGrid[j][0] == 0 && table[j-1][0] != 0)? 1:0);
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0)
                    table[i][j] = table[i-1][j] + table[i][j-1];
                else
                    table[i][j] = 0;
            }
        }
        return table[m-1][n-1];
    }
}