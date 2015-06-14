class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size()-1;
        int res = 0;
        
        while (i < j) {
            res = max(min(height[i],height[j]) * (j - i), res);
            height[i] > height[j] ? j--:i++;
        }
        return res;
    }
};