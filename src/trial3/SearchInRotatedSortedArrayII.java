package trial3;

public class SearchInRotatedSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,3,1,1,1}; 
		System.out.println(new SearchInRotatedSortedArrayII().search(A, 3));
	}
	/**
     * we still use binary search, however we need to search in both array
     */
    public boolean search(int[] A, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A==null || A.length<1)
        {
            return false;
        }
        return search(A, 0, A.length-1, target);
    }
    
    private boolean search(int[] A, int start, int end, int target)
    {
        if (start>end)
        {
            return false;
        }
        else
        {
            int middle=(start+end)/2;
            if (A[middle]==target)
            {
                return true;
            }
            // rotate here or condition met
            if ((target<A[middle] || A[start]>=A[middle]) && search(A, start, middle-1, target))
            {
                return true;
            }
            if ((target>A[middle] || A[middle]>=A[end]) && search(A, middle+1, end, target))
            {
                return true;
            }
            return false;
        }
    }
}
