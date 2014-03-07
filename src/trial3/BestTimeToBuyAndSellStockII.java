package trial3;

public class BestTimeToBuyAndSellStockII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * this problem should be similar as finding the set of increasing subsequences
     * we buy at the beginning of each such subsequence and sell at the end
     */
    public int maxProfit(int[] prices) {
        int profit=0;
        
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        
        int buy=prices[0];
        for (int i=1; i<prices.length; i++)
        {
            // end of a increasing subsequences
            if (prices[i]<prices[i-1])
            {
                // we need to avoid multiple transaction at the same time or a loss price
                profit+=prices[i-1]>buy?prices[i-1]-buy:0;
                // start a new sequence
                buy=prices[i];
            }
        }
        // for the last one
        if (prices[prices.length-1]>buy)
        {
            profit+=prices[prices.length-1]-buy;
        }
        return profit;
    }
}
