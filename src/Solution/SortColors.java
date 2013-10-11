public class Solution {
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // our algorithm is follows: we scan the array, whenever we met 0, we swap it with the first element
        // which is not zero (maintained by an index); or we met 2, we swap it the last element which is not 2.
        // After that, all 0 must be in the front of the array and 2 will be in the end of array
        if (A==null || A.length<1)
        {
            return;
        }
        int first0=0;
        int last2=A.length-1;
        int swap=0;
        for(int i=0; i<A.length && first0<=last2 && i<=last2 && i>=first0; i++)
        {
            // for 0, we make it to the front
            if (A[i]==0)
            {
                // swap it to the front
                while (A[first0]==0 && first0<i && first0<A.length-1)
                {
                    first0++;
                }
                swap=A[i];
                A[i]=A[first0];
                A[first0++]=swap;
                // note that, only 1 will be swaped back
            }
            // for 2, we make it to the end
            else if(A[i]==2)
            {
                while (A[last2]==2 && last2>i && last2>0)
                {
                    last2--;
                }
                swap=A[i];
                A[i]=A[last2];
                A[last2--]=swap;
                // in case, 0 is swapped ahead
                if (A[i]==0)
                {
                    i--;
                }
            }
        }
    }
}
