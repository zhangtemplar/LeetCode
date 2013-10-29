public class Solution {
    public int maxProfit(int[] prices) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (prices==null || prices.length<2)
        {
            return 0;
        }
        // we will use the first version
        // in addition, we will search for the partition (from 0:n), such that each parition includes only one operation
        int []left=leftProfit(prices);
        int []right=rightProfit(prices);
        // find the optimal partition: at least better than one transaction case
        int max=right[0];
        for (int i=1; i<prices.length; i++)
        {
            // may not engage in multiple transactions at the same time
            // [0:i-1][i:n-1]
            int profit=left[i-1]+right[i];
            if (profit>max)
            {
                max=profit;
            }
        }
        return max;
    }
    
    // result[i] is the max profit we can get if all the operation happens before i
    private int[] leftProfit(int []prices)
    {
        int []result=new int[prices.length];
        int buy=prices[0];
        for (int i=1; i<prices.length; i++)
        {
            // update the buy price, if we find a lower one
            if (buy>prices[i-1])
            {
                buy=prices[i-1];
            }
            // check the profit
            int profit=prices[i]-buy;
            // current profit is better
            if (profit>result[i-1])
            {
                result[i]=profit;
            }
            // previous profit is better
            else
            {
                result[i]=result[i-1];
            }
        }
        return result;
    }
    
    // similar as the previous one, however we require all operation after step i
    private int[] rightProfit(int []prices)
    {
        int []result=new int[prices.length];
        int sell=prices[prices.length-1];
        for (int i=prices.length-2; i>=0; i--)
        {
            // a higher sell price
            if (sell<prices[i+1])
            {
                sell=prices[i+1];
            }
            int profit=sell-prices[i];
            if (profit>result[i+1])
            {
                result[i]=profit;
            }
            else
            {
                result[i]=result[i+1];
            }
        }
        return result;
    }
}
