public class Solution {
    public int maxProfit(int[] prices) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the basic idea is, we buy the stock when the price is going to increase
        // we sell it when the price is going to drop
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        // flag for whether we have the stock or not
        boolean is_bought=false;
        int profit=0;
        int price_buy=0;
        int price_sell=0;
        for (int i=0; i<prices.length-1; i++)
        {
            // buy
            if (prices[i]<prices[i+1])
            {
                if (is_bought==false)
                {
                    price_buy=prices[i];
                    is_bought=true;
                }
            }
            // sell
            // else is used to avoid the sell and buy at the same lot
            else if (prices[i]>prices[i+1])
            {
                if (is_bought==true)
                {
                    price_sell=prices[i];
                    is_bought=false;
                    profit+=price_sell-price_buy;
                }
            }
        }
        // finally, we need to check whether we still hold the stock or not
        if (is_bought==true && prices[prices.length-1]>price_buy)
        {
            profit+=prices[prices.length-1]-price_buy;
            is_bought=false;
        }
        return profit;
    }
}
