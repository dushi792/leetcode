class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        // 注意： 左到中和中到右，两边必定有一边是递增的
        // (1）如果target==A[m]，那么m就是我们要的结果，直接返回；
        //（2）如果A[m]<A[r]，那么说明从m到r一定是有序的（没有受到rotate的影响），那么我们只需要判断target是不是在m到r之间，如果是则把左边缘移到m+1，否则就target在另一半，即把右边缘移到m-1。
        //（3）如果A[m]>=A[r]，那么说明从l到m一定是有序的，同样只需要判断target是否在这个范围内，相应的移动边缘即可。
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
