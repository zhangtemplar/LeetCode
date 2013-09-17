package Solution;

public class SortRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we still use the binary search
        // no matter how many and whether the rotation are
        // there is only one break point, otherwise it is the same as binary search in sorted
        if (A==null || A.length<1)
        {
            return -1;
        }
        return search(A, 0, A.length-1, target);
    }
    
    private int search(int []A, int start, int end, int target)
    {
        // basic case
        if (start>end)
        {
            return -1;
        }
        else if (start==end)
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
        // the other, we apply the binary search
        int middle=(start+end)/2;
        int result=-1;
        // for the left part
        // we need to search it
        if (A[start]<A[middle])
        {
            // left half is sorted
            if (A[start]<=target && A[middle]>=target)
            {
                result=search(A, start, middle, target);
                if (result>-1)
                {
                    return result;
                }
            }
        }
        else
        {
            // we need to search it, no matter how
            result=search(A, start, middle, target);
            if (result>-1)
            {
                return result;
            }
        }
        // for the right part
        // we need to search it
        if (A[middle+1]<A[end])
        {
            // left half is sorted
            if (A[middle+1]<=target && A[end]>=target)
            {
                result=search(A, middle+1, end, target);
                if (result>-1)
                {
                    return result;
                }
            }
        }
        else
        {
            // we need to search it, no matter how
            result=search(A, middle+1, end, target);
            if (result>-1)
            {
                return result;
            }
        }
        return result;
    }
}
