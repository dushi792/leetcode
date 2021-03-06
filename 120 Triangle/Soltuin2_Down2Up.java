// Better than Up2Down
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int[] sum = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            sum[i] = triangle.get(triangle.size()-1).get(i);
        }
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                sum[j] = Math.min(sum[j], sum[j+1]) + triangle.get(i).get(j);
            }
        }

        return sum[0];
    }
}
