public class Solution {
    public boolean search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we still use binary search
        // the only trick here is that, we need to be aware of the half, which contains the rotation
        if (A==null || A.length<1)
        {
            return false;
        }
        return search(A, 0, A.length-1, target);
    }
    
    private boolean search(int []A, int start, int end, int target)
    {
        // base case
        if (start==end)
        {
            return A[start]==target;
        }
        int middle=(start+end)/2;
        if (A[middle]==target)
        {
            return true;
        }
        else 
        {
            // search in the left half
            // if middle is larger than target or there is rotation in the left half
            if(A[middle]>target || A[start]>=A[middle])
            {
                if (start<middle && search(A, start, middle-1, target))
                {
                    return true;
                }
            }
            if(A[middle]<target || A[end]<=A[middle])
            {
                if (search(A, middle+1, end, target))
                {
                    return true;
                }
            }
            return false;
        }
    }
}
