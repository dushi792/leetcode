public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = res[1] = -1;
        int left = 0;
        int right = nums.length-1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < target) left = mid+1;
            else right = mid;
        }
        if (nums[left] != target) return res;
        else res[0] = left;

        right = nums.length-1;
        while (left < right) {
            // *重要：mid必须要+1，否则会导致始终执行语句else left = mid，引起死循环
            int mid = (left + right) / 2 + 1;
            if (nums[mid] > target) right = mid-1;
            else left = mid;
        }
        res[1] = right;

        return res;
    }
}
