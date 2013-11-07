public class Solution {
    public int divide(int dividend, int divisor) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will use long to avoid overflow
        return (int) divide((long) dividend, (long) divisor);
    }
    
    private long divide(long dividend, long divisor)
    {
        // some of the special case
        if (dividend<0)
        {
            return -divide(-dividend, divisor);
        }
        if (divisor<0)
        {
            return -divide(dividend, -divisor);
        }
        if (dividend==0 || dividend==0)
        {
            return 0;
        }
        if (dividend<divisor)
        {
            return 0;
        }
        // we will use binary search
        long result=0;
        while(dividend>=divisor)
        {
            long tmp=divisor;
            long current=1;
            while(dividend>(tmp<<1))
            {
                tmp=tmp<<1;
                current=current<<1;
            }
            result+=current;
            dividend-=tmp;
        }
        return result;
    }
}
