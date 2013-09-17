package Solution;

public class TrapRainWater {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TrapRainWater instance=new TrapRainWater();
		int []A={0, 2, 0};
		System.out.println(instance.trap(A));
	}

	public int trap(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A==null || A.length<3)
        {
            return 0;
        }
        int []left=new int[A.length];
        left[0]=A[0];
        for (int i=1; i<A.length; i++)
        {
            if (left[i-1]>A[i])
            {
                left[i]=left[i-1];
            }
            else
            {
                left[i]=A[i];
            }
        }
        int []right=new int[A.length];
        right[A.length-1]=A[A.length-1];
        for (int i=A.length-2; i>=0; i--)
        {
            if (right[i+1]>A[i])
            {
                right[i]=right[i+1];
            }
            else
            {
                right[i]=A[i];
            }
        }
        int result=0;
        int tmp;
        for (int i=1; i<A.length-1; i++)
        {
            tmp=(left[i-1]>right[i+1]?right[i+1]:left[i-1])-A[i];
            if (tmp>0)
            {
                result+=tmp;
            }
        }
        return result;
    }
}
