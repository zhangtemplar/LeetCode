public class Solution {
    public int removeElement(int[] A, int elem) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we maintain two pointer, one for the first empty lot and the other for the current processed lot
        if (A==null || A.length<1)
        {
            return 0;
        }
        int available=0;
        for (int i=0; i<A.length; i++)
        {
            // we found a different element save it to the first empty lot
            if (A[i]!=elem)
            {
                A[available]=A[i];
                available++;
            }
        }
        return available;
    }
}
