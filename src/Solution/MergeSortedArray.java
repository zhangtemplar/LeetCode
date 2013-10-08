public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A==null || A.length<1 || B==null || B.length<1 || n<1 || A.length<m+n)
        {
            return;
        }
        int i=m-1;
        int j=n-1;
        int k=A.length-1;
        // we start from the end
        while(i>=0 && j>=0)
        {
            if (A[i]>B[j])
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
        // clean up the remaining
        while(i>=0)
        {
            A[k]=A[i];
            k--;
            i--;
        }
        while(j>=0)
        {
            A[k]=B[j];
            k--;
            j--;
        }
    }
}
