public class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length && furthest >= i; i++) {
            if (nums[i]+i > furthest) furthest = nums[i]+i;
            if (furthest >= nums.length-1) return true;
        }
        return furthest >= nums.length-1;
    }
}
