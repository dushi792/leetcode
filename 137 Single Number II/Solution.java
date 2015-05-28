public class Solution {
    public int singleNumber(int[] nums) {
        int[] sum = new int[32];
        int result = 0;
        
        for (int i = 0; i < 32; i++) {
            sum[i] = 0;
            for (int j = 0; j < nums.length; j++) {
                sum[i] += (nums[j] >>> i) & 1;
            }
            sum[i] %= 3;
            result += sum[i] << i;
        }
        
        return result;
    }
}