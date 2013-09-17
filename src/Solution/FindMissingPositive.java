package Solution;

public class FindMissingPositive {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int firstMissingPositive(int[] A) 
	{
        // Start typing your Java solution below
        // DO NOT write main() function
        // we try to store the result to the array itself
        // we start from i=0;
        // if A[i]>0, we store it to A[A[i]-1] if possible
        // at the end, we just scan from the begining.
        // the difficulty is how to store the number it original in
        if (A==null || A.length<1)
        {
            return 1;
        }
        int swap=-1;
        int i=0;
        while(i<A.length)
        {
            // we need to process swap first
            if (swap>0)
            {
                if (A[swap-1]<0 || A[swap-1]>A.length || A[swap-1]==swap)
                {
                    // we are lucky, we just put it here
                    A[swap-1]=swap;
                    swap=-1;
                }
                else
                {
                    // we need to repear this process
                    int tmp=A[swap-1];
                    A[swap-1]=swap;
                    swap=tmp;
                }
            }
            else
            {
                if (A[i]>0 && A[i]<=A.length && A[i]-1!=i)
                {
                    // we need to save this number
                    if (A[A[i]-1]<0 || A[A[i]-1]>A.length || A[A[i]-1]==A[i])
                    {
                        // it is a negative number, we don't care and overwrite it
                        // it this number is too large, we can safely ignore it also
                        A[A[i]-1]=A[i];
                        A[i]=-1;
                    }
                    else
                    {
                        // this is another positive number, we need to store it somewhere else
                        swap=A[A[i]-1];
                        A[A[i]-1]=A[i];
                        A[i]=-1;
                        // we need to find a proper position to store swap
                    }
                }
                i++;
            }
        }
        for (i=0; i<A.length; i++)
        {
            if (A[i]!=i+1)
            {
                return i+1;
            }
        }
        return i+1;
    }
}
