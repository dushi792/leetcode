// Not Good: BackTracking TLE
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        backtrack(nums, target, res, 0, 0, 0);
        return res;
    }
    private void backtrack(int[] nums, int target, int res, int idx, int cnt, int sum3) {
        if (cnt > 3) return;
        if (cnt == 3) {
            if (Math.abs(sum3 - target) < Math.abs(res-target))
                res = sum3;
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            sum3 += nums[i];
            backtrack(nums, target, res, i+1, cnt+1, sum3);
            sum3 -= nums[i];
        }
    }
}
// O(n^2) https://leetcode.com/discuss/16335/java-solution-with-o-n2-for-reference
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[nums.length-1];

        for (int i = 0; i < nums.length-2; i++) {
            int next = i+1; int last = nums.length-1;
            while (next < last) {
                int sum = nums[i] + nums[next] + nums[last];
                if (Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;

                if (sum > target)
                    last--;
                else
                    next++;
            }
        }
        return result;
    }
}
