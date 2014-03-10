package trial3;

public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// the idea is that we start from the end
    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A==null || B==null || B.length<1)
        {
            return;
        }
        int i=m-1;
        int j=n-1;
        while(i>=0 && j>=0)
        {
            if (A[i]>B[j])
            {
                A[i+j+1]=A[i];
                i--;
            }
            else
            {
                A[i+j+1]=B[j];
                j--;
            }
        }
        // check the remaning
        while (j>=0)
        {
            A[j]=B[j];
            j--;
        }
    }
}
