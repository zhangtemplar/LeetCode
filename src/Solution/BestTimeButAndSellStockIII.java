package Solution;

import java.util.Arrays;

public class BestTimeButAndSellStockIII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeButAndSellStockIII instance=new BestTimeButAndSellStockIII();
		int[] prices={6,1,3,2,4,7};
		System.out.println(instance.maxProfit(prices));
	}
	
	public int maxProfit(int[] prices)
	{
		// a more efficient way is that, we process the array from two direction
		// and merge the result
		// O(N)
		if (prices==null || prices.length<2)
        {
            return 0;
        }
		int []forward=maxProfitForward(prices);
		int []backward=maxProfitBackward(prices);
		int profit=forward[prices.length-1];
		// we try different cutting location for two transaction
		for (int i=0; i<prices.length-1; i++)
		{
			// transaction happesn between [0, i] and [i+1, n-1]
			int tmp=forward[i]+backward[i+1];
            if (tmp>profit)
            {
                profit=tmp;
            }
		}
		return profit;
	}
	
	// we start the array from the end of the array
	// note, we change the logic slightly
	// we record the highest (sell) price until the current location
	private int[] maxProfitBackward(int[] prices)
	{
		int i=prices.length-2;
        int j=prices.length-1;
        // profit track the maximal profit available
        // when the buy location is no earlier than i
        if (prices==null || prices.length<1)
        {
            return null;
        }
        int []profit=new int[prices.length];
        profit[prices.length-1]=0;
        if (i<0)
        {
        	return profit;
        }
        for (; i>=0; i--)
        {
            if (prices[j]<prices[i+1])
            {
            	// ok, we have a higher sell price
                j=i+1;
            }
            if (profit[i+1]<prices[j]-prices[i])
            {
            	profit[i]=prices[j]-prices[i];
            }
            else
            {
            	profit[i]=profit[i+1];
            }
        }
        return profit;
	}
	
	// it tracks the profit where the sell position is no later than i
	private int[] maxProfitForward(int []prices)
	{
		int i=0;
        int j=1;
        int max=Integer.MIN_VALUE;
        if (prices==null || prices.length<1)
        {
            return null;
        }
        int []profit=new int[prices.length];
        profit[0]=0;
        if (j>=prices.length)
        {
        	return profit;
        }
        for (; j<prices.length; j++)
        {
            if (prices[i]>prices[j-1])
            {
                i=j-1;
            }
            if (profit[j-1]<prices[j]-prices[i])
            {
            	profit[j]=prices[j]-prices[i];
            }
            else
            {
            	profit[j]=profit[j-1];
            }
        }
        return profit;
	}

	public int maxProfitSlow(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // a simple algorithm is the following
        // we cut the array into halves and apply the solution of orignal algorithm
        // on each half and record their sum
        // we try all possible location to find the maximum
		// complexity is O(N^2)
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        BestTimeButAndSellStock instance=new BestTimeButAndSellStock();
        int profit=instance.maxProfit(prices);
        for (int i=2; i<prices.length; i++)
        {
            int tmp=instance.maxProfit(Arrays.copyOfRange(prices, 0, i))+instance.maxProfit(Arrays.copyOfRange(prices, i, prices.length));
            if (tmp>profit)
            {
                profit=tmp;
            }
        }
        return profit;
    }
}
