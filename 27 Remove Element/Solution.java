public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        for (; i < n; i++) {
            if (nums[i] != val)
                nums[j++] = nums[i];
        }
        return j;
    }
}