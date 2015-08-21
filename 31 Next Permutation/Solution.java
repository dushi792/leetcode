// 涉及到字典序知识
// 代码来源：http://www.jiuzhang.com/solutions/next-permutation/
public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = nums.length-2;
        for ( ; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                int j = nums.length-1;
                for (; j > i; j--) {
                    if (nums[j] > nums[i])
                        break;
                }
                swap(nums, i, j);
                reverse(nums, i+1);
                return;
            }
        }
        reverse(nums, 0);
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private void reverse(int[] nums, int i) {
        int k = nums.length-1;
        for (int j = i; j < k; j++, k--) {
            swap(nums, j, k);
        }
    }
}
