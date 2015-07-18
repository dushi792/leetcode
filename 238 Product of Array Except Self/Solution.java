public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        int left = 1;
        for (int i = 0; i < n-1; i++) {
            left *= nums[i];
            result[i+1] = left;
        }
        
        int right = 1;
        for (int i = n-1; i > 0; i--) {
            right *= nums[i];
            result[i-1] *= right;
        }
        
        return result;
    }
}