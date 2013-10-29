public class Solution {
    public int firstMissingPositive(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // obviously, this number should be smaller than A.length+1
        // so we can store the found positive number in A
        //  if A[i] is negative, we ignore it;
        //  if A[i]>A.length, we also ignore it;
        //  otherwise, we store it to A[A[i]-1]. Note, we may need to move the element already there
        if (A==null || A.length<1)
        {
            return 1;
        }
        for(int i=0; i<A.length; i++)
        {
            // we need to save this number
            if (A[i]>0 && A[i]<=A.length)
            {
                // we need to shift some element out
                int target=A[i];
                while(A[target-1]>0 && A[target-1]<=A.length && A[target-1]!=target)
                {
                    int tmp=A[target-1];
                    A[target-1]=target;
                    target=tmp;
                }
                if (target>0 && target<=A.length)
                {
                    A[target-1]=target;
                }
            }
            else
            {
                A[i]=0;
            }
        }
        // just scan from 0 to the end
        for(int i=0; i<A.length; i++)
        {
            if (A[i]!=i+1)
            {
                return i+1;
            }
        }
        return A.length+1;
    }
}
