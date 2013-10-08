public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // linear complexity
        if (A==null || A.length<1)
        {
            return 0;
        }
        int available=0;
        for (int i=0; i<A.length; i++)
        {
            if (A[i]!=A[available])
            {
                available++;
                A[available]=A[i];
            }
        }
        return available+1;
    }
}
