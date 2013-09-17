package Solution;

public class BestTimeButAndSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // now problems becomes find a set of pairs of buy and sell operation
        // the basic idea is that, we buy the stock if it is going to increase
        // when we find the price is going to drop, we sell it out
        // at buy it back at the next position
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        else if(prices.length==2)
        {
            if (prices[1]-prices[0]>0)
            {
                return prices[1]-prices[0];
            }
            else
            {
                return 0;
            }
        }
        int profit=0;
        int buy_price=-1;
        int sell_price=-1;
        // this indicates that we already has the stock
        boolean is_sold=true;
        for (int i=1; i<prices.length-1; i++)
        {
            // we find the price will increase
            // thus we buy in the stock
            if (prices[i]>prices[i-1] && is_sold) 
            {
                // buy the stock
                buy_price=prices[i-1];
                is_sold=false;
            }
            // we find the price will decrease
            // thus we sell off the stock (if it is possible)
            if (prices[i]>prices[i+1] && !is_sold)
            {
                // sell the stock
                sell_price=prices[i];
                is_sold=true;
                // record this profit
                profit+=sell_price-buy_price;
                // clear history
                // we assume the price is nonegative
                sell_price=-1;
                buy_price=-1;
            }
        }
        // track whether the last transaction is finised or not
        // i.e., we have already bought the stock but haven't sold it
        if (buy_price<0)
        {
            // we only check the buy_price for [0: n-3)
            if (prices[prices.length-2]<prices[prices.length-1])
            {
                profit+=prices[prices.length-1]-prices[prices.length-2];
            }
        }
        else if (sell_price<0)
        {
            // we need to decide whether this transaction is processed
            if (buy_price<prices[prices.length-1])
            {
                profit+=prices[prices.length-1]-buy_price;
            }
        }
        return profit;
    }
}
