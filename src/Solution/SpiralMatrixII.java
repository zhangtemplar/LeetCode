package Solution;

public class SpiralMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<1)
        {
            return new int[0][0];
        }
        int [][]matrix=new int[n][n];
        int spiral=n/2;
        // the main algorithm
        // this should work with the case m is even
        int i;
        int k=1;
        for (i=0; i<spiral; i++)
        {
            // for left-right
            for (int j=i; j<n-i-1; j++)
            {
                matrix[i][j]=k++;
            }
            // for top-down
            for (int j=i; j<n-i-1; j++)
            {
                matrix[j][n-i-1]=k++;
            }
            // for right-left
            for (int j=n-i-1; j>i; j--)
            {
                matrix[n-i-1][j]=k++;
            }
            // for bottom-top
            for (int j=n-i-1; j>i; j--)
            {
                matrix[j][i]=k++;
            }
        }
        // post-processing, check the special case, where m is odd
        if (n/2*2!=n)
        {
            matrix[i][i]=k;
        }
        return matrix;
    }
}
