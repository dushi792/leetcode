public class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        // furthest >= i：要注意当能到达的最远距离小于当前i的话，表示无法到达最后一个元素
        for (int i = 0; i < nums.length && furthest >= i; i++) {
            if (nums[i]+i > furthest) furthest = nums[i]+i;
            if (furthest >= nums.length-1) return true;
        }
        return furthest >= nums.length-1;
    }
}
