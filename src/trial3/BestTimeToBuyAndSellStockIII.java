package trial3;

public class BestTimeToBuyAndSellStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []prices={2,9,2,3,8,1,5,8,4,3,6,4,4};
		System.out.println(new BestTimeToBuyAndSellStockIII().maxProfit(prices));
	}
	/**
     * one solution is that, we cut the prices into two subarray
     * we apply the first algorithm on each of the subarray
     * the max profit is the sum of the max profit in each of the subarray
     * the complexity would be o(n2)
     */
    public int maxProfit(int[] prices) {
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        // the maximal profit by i
        int []forward=new int[prices.length];
        forward[0]=0;
        int low=prices[0];
        for (int i=1; i<prices.length; i++)
        {
            // we have a higher profit
            if (prices[i]>prices[i-1])
            {
                forward[i]=prices[i]>low?prices[i]-low:0;
            }
            else
            {
                forward[i]=forward[i-1];
            }
            if (forward[i]<forward[i-1])
            {
                forward[i]=forward[i-1];
            }
            if (low>prices[i])
            {
                low=prices[i];
            }
        }
        // the maximal profit since i
        int []backward=new int[prices.length];
        backward[prices.length-1]=0;
        int high=prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--)
        {
            if (prices[i]<prices[i+1])
            {
                backward[i]=high>prices[i]?high-prices[i]:0;
            }
            else
            {
                backward[i]=backward[i+1];
            }
            if (backward[i]<backward[i+1])
            {
                backward[i]=backward[i+1];
            }
            if (high<prices[i])
            {
                high=prices[i];
            }
        }
        // combine the result
        int profit=Math.max(forward[prices.length-1], backward[0]);
        for (int i=0; i<prices.length-1; i++)
        {
            // profit by i + profit since i+1
            if (profit<forward[i]+backward[i+1])
            {
                profit=forward[i]+backward[i+1];
            }
        }
        return profit;
    }
}
