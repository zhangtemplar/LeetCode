public class Solution {
    public int removeDuplicates(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the idea would be very similar
        if (A==null || A.length<1)
        {
            return 0;
        }
        int available=0;
        for (int i=0; i<A.length; i++)
        {
            if (available<=0 || A[i]!=A[available-1])
            {
                // not a duplicate
                A[available]=A[i];
                available++;
            }
            else if(available<=1 || A[i]!=A[available-2])
            {
                // first duplicate
                A[available]=A[i];
                available++;
            }
            // the second duplicate, overwrite it
        }
        return available;
    }
}
