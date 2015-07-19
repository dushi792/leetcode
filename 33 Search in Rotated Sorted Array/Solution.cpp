class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            //先判断数组整体趋势
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && nums[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }
            else {
                if (nums[right] >= target && nums[mid] <= target)
                    left = mid;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }
};