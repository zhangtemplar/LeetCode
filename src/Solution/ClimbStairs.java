package Solution;

public class ClimbStairs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use dynamic programming
        if (n<1)
        {
            return 0;
        }
        else if(n==1)
        {
            return 1;
        }
        else if(n==2)
        {
            return 2;
        }
        int []result=new int[n];
        result[0]=1;
        result[1]=2;
        for (int i=2; i<n; i++)
        {
            result[i]=result[i-1]+result[i-2];
        }
        return result[n-1];
    }
}
