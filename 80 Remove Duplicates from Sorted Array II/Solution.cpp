class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 1)
            return nums.size();
        int i = 0;
        int j = 1;
        int count = 0;
        for (; j < nums.size(); j++) {
            if (nums[i] != nums[j])
                count = 0;
            else
                count++;
            if (count < 2)
                nums[++i] = nums[j];
        }
        return i+1;
    }
};