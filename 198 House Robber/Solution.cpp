class Solution {
public:
    int rob(vector<int>& nums) {
        if (nums.size() == 0)
            return 0;
        int size = nums.size()+1;
        vector<int> profit(size);
        profit[0] = 0;
        profit[1] = nums[0];
        
        for (int i = 2; i < size; i++) {
            profit[i] = max(profit[i-1], profit[i-2]+nums[i-1]);
        }
        
        return profit[size-1];
    }
};