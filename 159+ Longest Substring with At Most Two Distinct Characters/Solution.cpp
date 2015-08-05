class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        if (s.empty())
            return 0;
        
        int dict[256];
        fill_n(dict, 256, 0);
        int start = 0, len = 1, count = 0;
        for (int k = 0; k < s.size(); k++) {
            dict[s[k]]++;
            if (dict[s[k]] == 1)
                count++;
            while (count > 2) {
                dict[s[start]]--;
                if (dict[s[start]] == 0) count--;
                start++;
            }
            if (k-start+1 > len)
                len = k-start+1;
        }
        return len;
    }
};