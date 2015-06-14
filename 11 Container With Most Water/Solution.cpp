class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size()-1;
        int max = 0;
        
        while (i < j) {
            int curr = min(height[i],height[j]) * (j - i);
            if (max < curr) {
                max = curr;
            }
            else {
                height[i] > height[j] ? j--:i++;
            }
        }
        return max;
    }
};