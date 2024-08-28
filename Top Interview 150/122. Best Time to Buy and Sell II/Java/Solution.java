class Solution {
    public int maxProfit(int[] prices) {
        /*
         * Brute force. Essentially just assume you buy and sell every time the next day 
         * is valued higher.
         */
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}