class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        if (nums[left] < nums[right])
            return nums[left];
        while (left < right) {
            if (nums[left] == nums[right]) {
                right--;
                continue;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right])
                left = mid+1;
            else
                right = mid;
        }
        return nums[left];
    }
};