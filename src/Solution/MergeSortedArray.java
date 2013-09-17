package Solution;

public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void merge(int A[], int m, int B[], int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we start from the end
        // we always put the larger element to the end of the array
        int i, j, k;
        i=m-1;
        j=n-1;
        k=A.length-1;
        while(i>=0 && j>=0)
        {
            if (A[i]>=B[j])
            {
                A[k]=A[i];
                i--;
            }
            else
            {
                A[k]=B[j];
                j--;
            }
            k--;
        }
        // post-processing
        // fill remaining of B to A
        while(j>=0)
        {
            A[k]=B[j];
            j--;
            k--;
        }
    }
}
