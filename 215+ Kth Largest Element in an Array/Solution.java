public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int i = nums.length - k;
        int lo = 0;
        int hi = nums.length -1;

        while (lo < hi) {
            int j = partition(nums, lo, hi);
            if (j < i) lo = j + 1;
            else if (j > i) hi = j - 1;
            else break;
        }
        return nums[i];

    }

    private int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high-1;
        while (true) {
            while (i < high && nums[++i] < nums[high])
            while (j > low  && nums[--j] > nums[high])
            if (i >= j) break;
            else swap(nums, i, j);
        }
        swap(nums, high, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
