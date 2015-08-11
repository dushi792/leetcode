// Reference: https://leetcode.com/discuss/10046/share-my-short-solution
public class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int leftmax = 0;
        int rightmax = 0;
        int res = 0;

        while (left < right) {
            leftmax = Math.max(height[left], leftmax);
            rightmax = Math.max(height[right], rightmax);
            if (leftmax < rightmax) {
                res += leftmax - height[left];
                left++;
            }
            else {
                res += rightmax - height[right];
                right--;
            }
        }
        return res;
    }
}
