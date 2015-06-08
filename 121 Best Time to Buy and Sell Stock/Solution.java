public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1 || prices == null)
            return 0;
        
        int maxpft = 0;
        int curpft = 0;
        
        for (int i = 1; i < prices.length; i++) {
            curpft = Math.max(prices[i]-prices[i-1]+curpft, 0);
            maxpft = Math.max(curpft, maxpft);
        }
        return maxpft;
    }
}