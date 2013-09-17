package Solution;

public class BestTimeButAndSellStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the maximal profit is the maximal gain between buy price and sell price
        // in addition that, the buy should happen before sell
        // the algorithm is the follows
        // let i be the current buy position and j for sell position
        // initialize i=0; j=1;
        // iterate the following two steps
        // j++
        // find the minimum between [i j)
        // complexity is o(n)
        int i=0;
        int j=1;
        int max=Integer.MIN_VALUE;
        if (prices==null || prices.length<1)
        {
            return 0;
        }
        for (; j<prices.length; j++)
        {
            if (prices[i]>prices[j-1])
            {
                i=j-1;
            }
            if (max<prices[j]-prices[i])
            {
                max=prices[j]-prices[i];
            }
        }
        if (max<0)
        {
            max=0;
        }
        return max;
    }
}
