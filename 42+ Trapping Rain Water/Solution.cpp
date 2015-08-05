class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0, right = height.size()-1;
        int maxleft = 0, maxright = 0;
        int sum = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > maxleft) maxleft = height[left];
                else sum += maxleft - height[left];
                left++;
            }
            else {
                if (height[right] > maxright) maxright = height[right];
                else sum += maxright - height[right];
                right--;
            }
        }
        return sum;
    }
};

//DP (need review) detail one: http://blog.csdn.net/wzy_1988/article/details/17752809
class Solution {
public:
    int trap(vector<int>& height) {
        if(height.size() <= 2)
            return 0;  
        int maxium = 0;  
        int res = 0;  
        vector<int> container(height.size());
        for(int i=0;i<height.size();i++)  
        {  
            container[i]=maxium;  
            maxium = max(maxium,height[i]);  
        }  
        maxium = 0;  
        for(int i=height.size()-1;i>=0;i--)  
        {  
            container[i] = min(maxium,container[i]);  
            maxium = max(maxium,height[i]);  
            res += container[i]-height[i]>0?container[i]-height[i]:0;  
        }      
        return res;  
    }
};