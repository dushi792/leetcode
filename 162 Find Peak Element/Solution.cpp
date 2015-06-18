class Solution {
public:
    int findPeakElement(vector<int>& nums) {
		//Binary search
        int i = 0;
        int j = nums.size() - 1;
        
        while (i < j) {
            int m = (i + j) / 2;
            if (nums[m] > nums[m+1] && nums[m] > nums[m-1])
                return m;
            
            if (nums[m] < nums[m+1])
                i = m+1;
            else
                j = m;
        }
    }
};