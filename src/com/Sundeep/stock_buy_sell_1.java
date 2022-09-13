package com.Sundeep;

public class stock_buy_sell_1 {
    public int maxProfit(int[] prices) {
        int minsofar = prices[0];
        int maxprofit = 0;
        for(int i=1;i<prices.length;i++){
            minsofar = Math.min(minsofar,prices[i]);
            int profit = prices[i] - minsofar;
            maxprofit = Math.max(maxprofit,profit);
        }
        return maxprofit;
    }
}
