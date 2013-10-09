public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // so we buy at the lowest price and sell at the highest price at the purchase
        // if the buy-price>sell_price, we don't make any transaction
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        int price_buy=prices[0];
        int price_sell=prices[1];
        int profit=0;
        for (int i=1; i<prices.length; i++)
        {
            // check whether we have a lower buy price
            if (price_buy>prices[i-1])
            {
                price_buy=prices[i-1];
            }
            price_sell=prices[i];
            // check whether we have a higher profit
            if (profit<price_sell-price_buy)
            {
                profit=price_sell-price_buy;
            }
        }
        return profit;
    }
}
