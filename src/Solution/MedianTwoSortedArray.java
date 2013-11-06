public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // the basic idea is binary search
        // we pick the median of one array, we know how many data is smaller/bigger than it
        // we then find the median in the other array, we show know the position of this median in the other array
        if (A==null || A.length<1)
        {
            if (B==null || B.length<1)
            {
                return 0;
            }
            else if (B.length%2==0)
            {
            	return (0.0+B[B.length/2]+B[B.length/2-1])/2;
            }
            else
            {
                return (double) B[B.length/2];
            }
        }
        else
        {
            if (B==null || B.length<1)
            {
            	if (A.length%2==0)
            	{
            		return (0.0+A[A.length/2]+A[A.length/2-1])/2;
            	}
            	else
            	{
            		return (double) A[A.length/2];
            	}
            }
            else if ((A.length+B.length)%2==0)
            {
                return (0.0+findMedianSortedArrays(A, 0, A.length-1, B, 0, B.length-1, (A.length+B.length)/2)+findMedianSortedArrays(A, 0, A.length-1, B, 0, B.length-1, (A.length+B.length)/2+1))/2;
            }
            else
            {
                return (double) findMedianSortedArrays(A, 0, A.length-1, B, 0, B.length-1, (A.length+B.length)/2+1);
            }
        }
    }
    
    /**
     * @param A, start1, end1: the subarray is A[start1: end1]
     * @param B, start2, end2: the subarray is B[start2: end2]
     * @param target the number we are looking for
     */
    private int findMedianSortedArrays(int A[], int start1, int end1, int B[], int start2, int end2, int target)
    {
        // in case A is empty
        if (start1>end1)
        {
            return B[target+start2-1];
        }
        // in case B is empty
        if (start2>end2)
        {
            return A[target+start1-1];
        }
        // we need to check the condition
        if (target==1)
        {
            return Math.min(A[start1], B[start2]);
        }
        // search the median of A in B
        int middle=(start1+end1)/2;
        int idx=Arrays.binarySearch(B, start2, end2+1, A[middle]);
        // this value is not found
        if (idx<0)
        {
            // A[middle] is smaller than B[idx]
            idx=-1-idx;
            // there are middle+idx-start2 numbers smaller than A[middle]
            int position=middle+1-start1+idx-start2;
            if (position==target)
            {
                return A[middle];
            }
            // this value is still two big, search in the left half
            else if(position>target)
            {
                return findMedianSortedArrays(B, start2, idx-1, A, start1, middle-1, target);
            }
            // this value is too small, try the right half
            // the left half has position=idx-start2+middle-start1+1 elements
            else
            {
                return findMedianSortedArrays(B, idx, end2, A, middle+1, end1, target-position);
            }
        }
        else
        {
            // A[middle]=B[idx]
            // there are middle+idx-start2 numbers smaller than A[middle]
            int position=middle+1-start1+idx-start2;
            if (position==target || position+1==target)
            {
                return A[middle];
            }
            // this value is still two big, search in the left half
            else if(position>target)
            {
                return findMedianSortedArrays(B, start2, idx-1, A, start1, middle-1, target);
            }
            // this value is too small, try the right half
            // the left half has position+1=idx-start2+1+middle-start1+1 elements
            else
            {
                return findMedianSortedArrays(B, idx+1, end2, A, middle+1, end1, target-position-1);
            }
        }
    }
}
