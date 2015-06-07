public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = 1;
            }
        }
        
        //都从1开始
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i-1][j] + res[i][j-1];
            }
        }
        
        return res[m-1][n-1];
    }
}


//省内存版
public class Solution {
    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        
        for (int i = 0; i < m; i++){
            for (int j = 1; j < n; j++) {
                res[j] += res[j-1];
            }
        }
        
        return res[n-1]
    }
}