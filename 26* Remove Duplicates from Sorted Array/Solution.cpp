class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.size() <= 1)
            return nums.size();
            
        int i = 0;
        //http://siddontang.gitbooks.io/leetcode-solution/content/array/remove_duplicates_from_sorted_array.html
        for (int j = 1; j < nums.size(); j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }
};