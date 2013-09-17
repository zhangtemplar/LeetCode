package Solution;

public class SearchInsert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // this is exactly what the Arrays.binarySearch() does
        if (A==null || A.length<1)
        {
            return 0;
        }
        int result=searchInsert(A, 0, A.length-1, target);
        if (result<0)
        {
            return -1-result;
        }
        else
        {
            return result;
        }
    }
    
    /**
     * this function returns the index of target
     *      >0, if the target is found
     *      <0, if the target is not found, we instead return the location it should be inserted
     *          -1-i;
     */
    private int searchInsert(int[] A, int start, int end, int target)
    {
        // basic case
        if (start>end)
        {
            // this should never happen
            return -1-start;
        }
        if (start==end)
        {
            if (A[start]==target)
            {
                return start;
            }
            else if (A[start]>target)
            {
                // it should be inserted before it
                return -1-start;
            }
            else
            {
                return -2-start;
            }
        }
        int middle=(start+end)/2;
        // search for the left
        if (A[middle]>=target && A[start]<=target)
        {
            return searchInsert(A, start, middle, target);
        }
        // for the right
        else if (A[middle+1]<=target && A[end]>=target)
        {
            return searchInsert(A, middle+1, end, target);
        }
        // my god, either halves works
        // there is only one possibility:
        // target is either too small or too large
        else if (A[start]>target)
        {
            return -1-start;
        }
        else if (A[end]<target)
        {
            return -2-end;
        }
        else
        {
            return -2-middle;
        }
    }
}
