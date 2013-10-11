public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // binary search
        // the only different is that, when we find a solution, we don't immediately stop the algorithm
        int []result=new int[2];
        if (A==null || A.length<1)
        {
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        return searchRange(A, 0, A.length-1, target);
    }
    
    private int[] searchRange(int[] A, int start, int end, int target)
    {
        int []result=new int[2];
        result[0]=-1;
        result[1]=-1;
        // base case
        if (start==end)
        {
            if (A[start]!=target)
            {
                result[0]=-1;
                result[1]=-1;
            }
            else
            {
                result[0]=start;
                result[1]=end;
            }
        }
        else
        {
            int middle=(start+end)/2;
            if (A[middle]==target)
            {
                result[0]=middle;
                result[1]=middle;
            }
            // in the right half
            int []result_right=new int[2];
            result_right[0]=-1;
            result_right[1]=-1;
            if (A[middle]<=target)
            {
                result_right=searchRange(A, middle+1, end, target);
            }
            // in the left half
            int []result_left=new int[2];
            result_left[0]=-1;
            result_left[1]=-1;
            if (A[middle]>=target && middle>start)
            {
                result_left=searchRange(A, start, middle-1, target);
            }
            // merge the result
            // left boundary
            if (result_left[0]>=0)
            {
                result[0]=result_left[0];
            }
            else if(result[0]<0)
            {
                result[0]=result_right[0];
            }
            // right boundary
            if (result_right[1]>=0)
            {
                result[1]=result_right[1];
            }
            else if(result[1]<0)
            {
                result[1]=result_left[1];
            }
        }
        return result;
    }
}
