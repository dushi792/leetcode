class Solution {
public:
    bool isHappy(int n) {
        if (n <= 0)
            return false;
            vector<int> res;
        while ( n != 1) {
            res.push_back(n);
            n = squareSum(n);
            if (find(res.begin(), res.end(), n) != res.end())
                return false;
        }
        return true;
    }
    
    int squareSum (int n) {
        int sum = 0;
        while (n > 0) {
            sum += pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
};

//Adapt the Floyd Cycle 快慢双指针检测闭环
class Solution {
public:
    bool isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        
        do {
            slow = squareSum(slow);
            fast = squareSum(fast);
            fast = squareSum(fast);
        } while(slow != fast);
        if (slow == 1)
            return true;
        else
            return false;
    }
    
    int squareSum (int n) {
        int sum = 0;
        while (n > 0) {
            sum += pow(n%10, 2);
            n /= 10;
        }
        return sum;
    }
};