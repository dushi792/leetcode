public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0)
            return 0;
            
        int buyprice = prices[0];
        int preprice = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= preprice) {
                preprice = prices[i];
            }
            else {
                profit += preprice - buyprice;
                buyprice = prices[i];
                preprice = prices[i];
            }
        }
        if (prices[prices.length-1] > buyprice)
            profit += prices[prices.length-1] - buyprice;
        return profit;
    }
}
