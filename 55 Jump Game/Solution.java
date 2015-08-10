public class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        // 实际上这是DP
        // furthest >= i：要注意当能到达的最远距离小于当前i的话，表示无法到达最后一个元素
        for (int i = 0; i < nums.length && furthest >= i; i++) {
            //if (nums[i]+i > furthest) furthest = nums[i]+i;
            furthest = nums[i] + i > furthest ? nums[i] + i : furthest;
            if (furthest >= nums.length-1) return true;
        }
        return furthest >= nums.length-1;
    }
}
