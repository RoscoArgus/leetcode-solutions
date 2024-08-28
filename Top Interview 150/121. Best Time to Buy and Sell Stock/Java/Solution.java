class Solution {
    public int maxProfit(int[] prices) {
        int minBuyPrice = prices[0]; // first will always be the immediate minimum
        int maxProfit = 0;

        for(int i=1; i<prices.length; i++) {
            /*
             * if the current price is less than the minimum buy price, update the minimum 
             * buy price
            */
            if(prices[i] < minBuyPrice)
                minBuyPrice = prices[i];
            /* 
             * if the current price minus the minimum buy price is greater than the current max 
             * profit, update the max profit. This ignores the current day as profit would be 0;
            */ 
            if((prices[i] - minBuyPrice) > maxProfit) 
                maxProfit = prices[i] - minBuyPrice;
        }

        return maxProfit;
    }
}