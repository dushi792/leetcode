class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty())
            return 0;
        unordered_set<int> hash;
        for (int i:nums)
            hash.insert(i);
        int maxlen = 1;
        for (int i = 0; i < nums.size(); i++) {
            if (hash.empty())
                break;
            int curlen = 0;
            int curnum = nums[i];
            while (hash.find(curnum)!= hash.end()) {
                hash.erase(curnum);
                curlen++;
                curnum++;
            }
            curnum = nums[i]-1;
            while(hash.find(curnum)!= hash.end()) {
                hash.erase(curnum);
                curlen++;
                curnum--;
            }
            maxlen = max(maxlen, curlen);
        }
        return maxlen;
    }
};