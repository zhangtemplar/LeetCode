public class Solution {
    public int search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we still use binary search
        // the only trick here is that, we need to be aware of the half, which contains the rotation
        if (A==null || A.length<1)
        {
            return -1;
        }
        return search(A, 0, A.length-1, target);
    }
    
    private int search(int []A, int start, int end, int target)
    {
        // base case
        if (start==end)
        {
            if (A[start]==target)
            {
                return start;
            }
            else
            {
                return -1;
            }
        }
        int middle=(start+end)/2;
        if (A[middle]==target)
        {
            return middle;
        }
        else 
        {
            int result=-1;
            // search in the left half
            // if middle is larger than target or there is rotation in the left half
            if(A[middle]>target || A[start]>=A[middle])
            {
                if (start<middle)
                {
                    result=search(A, start, middle-1, target);
                    if (result>=0)
                    {
                        return result;
                    }
                }
            }
            if(A[middle]<target || A[end]<=A[middle])
            {
                result=search(A, middle+1, end, target);
                if (result>=0)
                {
                    return result;
                }
            }
            return result;
        }
    }
}
