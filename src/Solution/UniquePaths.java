package Solution;

public class UniquePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePaths(int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we use recursion
        // f(m, n)=f(m-1,n)+f(m,n-1)
        // i.e., (m,n) can only be reached from its left or top
        // we need to use dynamic programming
        if (m<1 || n<1)
        {
            return 0;
        }
        if (m==1 || n==1)
        {
            return 1;
        }
        else
        {
            int [][]result=new int[m][n];
            for (int i=0; i<m; i++)
            {
                result[i][0]=1;
            }
            for (int j=0; j<n; j++)
            {
                result[0][j]=1;
            }
            for (int i=1; i<m; i++)
            {
                 for (int j=1; j<n; j++)
                 {
                     result[i][j]=result[i-1][j]+result[i][j-1];
                 }
            }
            return result[m-1][n-1];
        }
    }
}
