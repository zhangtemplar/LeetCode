public class Solution {
    public int searchInsert(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we shall use a binary search
        if (A==null || A.length<1)
        {
            return 0;
        }
        return searchInsert(A, 0, A.length-1, target);
    }
    
    private int searchInsert(int[] A, int start, int end, int target)
    {
        // base case
        if(start==end)
        {
            if (target==A[start])
            {
                return start;
            }
            else if (target>A[start])
            {
                return start+1;
            }
            else
            {
                return start;
            }
        }
        // use binary search
        int middle=(start+end)/2;
        // we found it
        if (target==A[middle])
        {
            return middle;
        }
        else if (target<A[middle])
        {
            // in case start=end-1
            if (start==middle)
            {
                return start;
            }
            else
            {
                return searchInsert(A, start, middle-1, target);
            }
        }
        else
        {
            return searchInsert(A, middle+1, end, target);
        }
    }
}
