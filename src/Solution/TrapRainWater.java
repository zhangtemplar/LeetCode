public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the water can be hold is the difference between the elevation of current location
        // to the minimal of elevation of left maximal and right maximal
        if (A==null || A.length<3)
        {
            return 0;
        }
        int []left=new int[A.length];
        left[0]=A[0];
        for (int i=1; i<A.length; i++)
        {
            left[i]=A[i]>left[i-1]?A[i]:left[i-1];
        }
        int []right=new int[A.length];
        right[A.length-1]=A[A.length-1];
        for (int i=A.length-2; i>=0; i--)
        {
            right[i]=A[i]>right[i+1]?A[i]:right[i+1];
        }
        int water=0;
        for (int i=1; i<A.length-1; i++)
        {
            if (A[i]<left[i] && A[i]<right[i])
            {
                water+=(left[i]<right[i]?left[i]:right[i])-A[i];
            }
        }
        return water;
    }
}
