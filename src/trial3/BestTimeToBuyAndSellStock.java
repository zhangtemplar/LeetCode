package trial3;

public class BestTimeToBuyAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * to get the maximal profit, always buy at lowest price and sell at highest price
     */
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        int lowest=prices[0];
        int profit=0;
        for (int i=1; i<prices.length; i++)
        {
            // set at i?
            if (profit<prices[i]-lowest)
            {
                profit=prices[i]-lowest;
            }
            // buy at i?
            if (lowest>prices[i])
            {
                lowest=prices[i];
            }
        }
        return profit;
    }
}
