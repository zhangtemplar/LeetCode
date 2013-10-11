public class Solution {
    public boolean canJump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // dynamic programming
        // f[i] the remaining steps when we go from 0 to i. If f[i]<0, we can't even make to i
        // f[i]=0, i=0;
        // f[i]=max(f[i-1], A[i-1])-1
        // from 0 to i-1, we have two choice: we first go to i-1, then move to i; or we move from
        // some location which lead to i-1.
        if (A==null || A.length<1)
        {
            return true;
        }
        int []buffer=new int[A.length];
        buffer[0]=0;
        for (int i=1; i<A.length; i++)
        {
            buffer[i]=Math.max(buffer[i-1],A[i-1])-1;
            if (buffer[i]<0)
            {
                return false;
            }
        }
        return buffer[A.length-1]>=0;
    }
}
