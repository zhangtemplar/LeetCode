public class Solution {
    public int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we can use dynamic programming
        // f(i) is the min # of jumps required from i to n-1 (i.e., end)
        // f(i)=0, i>=n-1;
        // f(i)=1, i+A[i]>=n-1;
        // f(i)=min_{j:i+n(i)>=j}{f(j)}+1
        // the complexity should be O(n^2), where the worst case comes from search in the minimal
        if (A==null || A.length<2)
        {
            return 0;
        }
        int []buffer=new int[A.length];
        buffer[A.length-1]=0;
        // we also keep a location of the previous minimum
        int index=A.length;
        for (int i=A.length-2; i>=0; i--)
        {
            int min=Integer.MAX_VALUE;
            // we know the minimum in the first section of the range
            // then we only need to check the second section
            if (i+A[i]>=i+1+A[i+1])
            {
                // we already knows that buffer[i]=min_{j:i+n(i)>=j}{f(j)}+1
                if (buffer[i+1]>0)
                {
                    min=buffer[i+1]-1;
                }
                else
                {
                    min=0;
                }
                for (int j=i+2+A[i+1]; j<=A.length-1 && j<=i+A[i]; j++)
                {
                    if (min>buffer[j])
                    {
                        min=buffer[j];
                        index=j;
                    }
                }
            }
            else if(index<=i+A[i])
            {
                // we know the previous minimum can be directly used here
                if (buffer[i+1]>0)
                {
                    min=buffer[i+1]-1;
                }
                else
                {
                    min=0;
                }
            }
            else
            {
                // unfortunately, we need do a full search in the new range
                for (int j=i+1; j<=A.length-1 && j<=i+A[i]; j++)
                {
                    if (min>buffer[j])
                    {
                        min=buffer[j];
                        index=j;
                    }
                }
            }
            // this means there is no step out
            if (min==Integer.MAX_VALUE)
            {
                buffer[i]=Integer.MAX_VALUE;
            }
            else
            {
                buffer[i]=min+1;
            }
        }
        return buffer[0];
    }
}
