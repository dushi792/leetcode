int maxProfit(int* prices, int pricesSize) {
    if (pricesSize == 0)
        return 0;
        
    int buyprice = prices[0];
    int profit = 0;
    for (int i = 1; i < pricesSize; i++) {
        if (prices[i] >= prices[i-1]) {
        }
        else {
            profit += prices[i-1] - buyprice;
            buyprice = prices[i];
        }
    }
    if (prices[pricesSize-1] > buyprice)
        profit += prices[pricesSize-1] - buyprice;
    return profit;
}