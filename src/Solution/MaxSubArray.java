package Solution;

public class MaxSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // it is the famous max sum problem
        // we keep two variables
        //  max_sum, which is the maximal of the sum of an continuous array
        //  cur_sum, which is the cumultive sum from the end of last continuous array which is negative sum
		int max_sum=Integer.MIN_VALUE;
        int cur_sum=0;
        if (A==null || A.length<1)
        {
            return 0;
        }
        for (int i=0; i<A.length; i++)
        {
            if (cur_sum<0)
            {
                cur_sum=0;
            }
            cur_sum+=A[i];
            if (cur_sum>max_sum)
            {
                max_sum=cur_sum;
            }
        }
        return max_sum;
    }
}
