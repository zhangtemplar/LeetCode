public class Solution {
    public int maxSubArray(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use linear complexity algorithm
        if (A==null || A.length<1)
        {
            return 0;
        }
        int result=Integer.MIN_VALUE;
        int cum=0;
        for (int i=0; i<A.length; i++)
        {
            cum+=A[i];
            if (cum>result)
            {
                result=cum;
            }
            if (cum<0)
            {
                cum=0;
            }
        }
        return result;
    }
}
