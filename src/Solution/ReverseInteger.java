public class Solution {
    public int reverse(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // for negative number
        if (x<0)
        {
            return -reverse(-x);
        }
        // we store the value as long number to avoid overflow
        long val=x;
        long result=0;
        while(val>0)
        {
            result=result*10+val%10;
            val=val/10;
        }
        // if overflow happens, we just cut it to the limit of the data type
        if (result>Integer.MAX_VALUE)
        {
            return Integer.MAX_VALUE;
        }
        return (int)result;
    }
}
