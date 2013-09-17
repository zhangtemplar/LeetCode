package Solution;

public class SearchRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will do it similarly as binary search, however,
        // instead of direct return when getting search result
        // we need to wait for the other results
        if (A==null || A.length<1)
        {
            int[] result=new int[2];
            result[0]=-1;
            result[1]=-1;
            return result;
        }
        return searchRange(A, 0, A.length-1, target);
    }
    
    private int[] searchRange(int[] A, int start, int end, int target)
    {
        // basic case
        int[] result=new int[2];
        result[0]=-1;
        result[1]=-1;
        if (start>end)
        {
            return result;
        }
        if (start==end)
        {
            if (A[start]==target)
            {
                result[0]=start;
                result[1]=start;
            }
            return result;
        }
        int middle=(start+end)/2;
        // search for the left
        int[] result_left=new int[2];
        result_left[0]=-1;
        result_left[1]=-1;
        if (A[middle]>=target && A[start]<=target)
        {
            result_left=searchRange(A, start, middle, target);
        }
        // for the right
        int[] result_right=new int[2];
        result_right[0]=-1;
        result_right[1]=-1;
        if (A[middle+1]<=target && A[end]>=target)
        {
            result_right=searchRange(A, middle+1, end, target);
        }
        // merge the result
        if (result_left[1]>-1 && result_right[0]>-1)
        {
            result_left[1]=result_right[1];
            return result_left;
        }
        else if (result_left[1]>-1)
        {
            return result_left;
        }
        else
        {
            return result_right;
        }
    }
}
