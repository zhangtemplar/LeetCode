package Solution;

import java.util.Arrays;
import java.util.Random;

public class MedianTwoSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr1={1, 2};//randomArray(8, 10);
        Arrays.sort(arr1);
		System.out.println(printArray(arr1));
		int []arr2={3, 4, 5, 6, 7, 8, 9};//randomArray(2, 10);
        Arrays.sort(arr2);
		System.out.println(printArray(arr2));
		System.out.println("The median is "+findMedianSortedArrays(arr1, arr2));
	}

	public static int[]randomArray(int m, int n)
	{
		Random seed=new Random();
		int []arr=new int[m];
		for (int i=0; i<m; i++)
		{
			arr[i]=seed.nextInt(n);
		}
		return arr;
	}
	
	public static int[]randomArray(int m)
	{
		return randomArray(m, m);
	}
	
	public static String printArray(int []arr)
	{
		StringBuffer str=new StringBuffer();
		for (int i=0; i<arr.length; i++)
		{
			str.append(arr[i]+",");
		}
		return str.toString();
	}
	
    public static double findMedianSortedArrays(int A[], int B[]) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we use binary search to find the position of median of one array in the other
        if (A==null || A.length<1)
        {
            if ((B.length%2)==0)
            {
                return (B[B.length/2]+B[(B.length)/2-1])/2.0;
            }
            else
            {
                return (double)B[B.length/2];
            }
        }
        if (B==null || B.length<1)
        {
            if ((A.length%2)==0)
            {
                return (A[A.length/2]+A[(A.length)/2-1])/2.0;
            }
            else
            {
                return (double)A[A.length/2];
            }
        }
        if (A.length>B.length)
        {
            if ((A.length+B.length)%2==0)
            {
                return (findKthSortedArrays(A, 0, A.length-1, B, 0, B.length-1, (A.length+B.length)/2)+findKthSortedArrays(A, 0, A.length-1, B, 0, B.length-1, (A.length+B.length)/2-1))/2.0;
            }
            else
            {
                return (double)findKthSortedArrays(A, 0, A.length-1, B, 0, B.length-1, (A.length+B.length)/2);
            }
        }
        else
        {
            if ((A.length+B.length)%2==0)
            {
                return (findKthSortedArrays(B, 0, B.length-1, A, 0, A.length-1, (A.length+B.length)/2)+findKthSortedArrays(B, 0, B.length-1, A, 0, A.length-1, (A.length+B.length)/2-1))/2.0;
            }
            else
            {
                return (double)findKthSortedArrays(B, 0, B.length-1, A, 0, A.length-1, (A.length+B.length)/2);
            }
        }
    }
    
    private static int findKthSortedArrays(int A[], int start_A, int end_A, int B[], int start_B, int end_B, int k)
    {
        if (k==0)
    	{
    		return A[start_A]>B[start_B]?B[start_B]:A[start_A];
    	}
    	if (k==1)
    	{
    		// min and second min
    		int x, y;
    		if (A[start_A]<B[start_B])
    		{
    			x=A[start_A];
    			y=B[start_B];
    		}
    		else
    		{
    			y=A[start_A];
    			x=B[start_B];    			
    		}
    		if (start_A<end_A)
    		{
    			if (A[start_A+1]<x)
    			{
    				y=x;
    				x=A[start_A+1];
    			}
    			else if (A[start_A+1]<y)
    			{
    				y=A[start_A+1];
    			}
    		}
    		if (start_B<end_B)
    		{
    			if (B[start_B+1]<x)
    			{
    				y=x;
    				x=B[start_B+1];
    			}
    			else if (B[start_B+1]<y)
    			{
    				y=B[start_B+1];
    			}    			
    		}
    		return y;
    	}
        int i, j;
        i=(start_A+end_A)/2;
        // check the base case
    	// special case: A>B or B>A
    	if (end_A>=A.length)
    	{
    		end_A--;
    	}
    	if (end_B>=B.length)
    	{
    		end_B--;
    	}
        j=Arrays.binarySearch(B, start_B, end_B+1, A[i]);
        // in case A[i] is not found in B
        if (j<0)
        {
            j=-1-j;
        }
        i=i-start_A;
        j=j-start_B;
        // in case A[i]>B
        if (j+start_B>end_B)
        {
        	if (i+j<=k)
        	{
        		// B can be totally discarded
        		return A[k-j+start_A];
        	}
        	else
        	{
        		// search in lower half of A and also B
        		// A[i]>k_th smallest
                if (start_B==end_B)
                {
                    // in case B is singleton, we need to make sure A is always reduced by half
                    return findKthSortedArrays(A, start_A, i+start_A, B, start_B, end_B, k);
                }
                else
                {
                    return findKthSortedArrays(B, start_B, end_B, A, start_A, i+start_A, k);
                }
        	}
        }
         // check the j
        if (i+j==k)
        {
            // we found the solution
            return A[i+start_A];
        }
        else if (i+j<k)
        {
            // A[i]<k_th smallest number
            // we need to swap A and B to make sure the speed
            // the algorithm requires at most O(log(m+n)) iterations
            if (start_B==end_B)
            {
                // in case B is singleton, we need to make sure A is always reduced by half
                return findKthSortedArrays(A, i+1+start_A, end_A, B, j+start_B, end_B, k-i-j-1);
            }
            else
            {
                return findKthSortedArrays(B, j+start_B, end_B, A, i+1+start_A, end_A, k-i-j-1);
            }
        }
        else
        {
            // A[i]>k_th smallest
            if (start_B==end_B)
            {
                // in case B is singleton, we need to make sure A is always reduced by half
                return findKthSortedArrays(A, start_A, i+start_A, B, start_B, j+start_B, k);
            }
            else
            {
                return findKthSortedArrays(B, start_B, j+start_B, A, start_A, i+start_A, k);
            }
        }
    }
    
    /**
     * this function finds the smallest index, where the value is identical to x
     * The array is sorted
     * @param arr
     * @param start
     * @param end
     * @param x
     * @return
     */
    public static int findFirstIdentical(int []arr, int start, int end, int x)
    {
    	for (int i=x-1; i>=start; i--)
    	{
    		if (arr[i]!=arr[x])
    		{
    			return i+1;
    		}
    	}
    	return start;
    }
}
