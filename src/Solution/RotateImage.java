package Solution;

public class RotateImage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (matrix==null || matrix.length<1)
        {
            return;
        }
        int a, b, c, d;
        int n=matrix.length;
        // we only need to process quater of the matrix
        for (int i=0; i<(n+1)/2; i++)
        {
            for (int j=0; j<n/2; j++)
            {
                a=matrix[i][j];
                b=matrix[j][n-i-1];
                c=matrix[n-i-1][n-j-1];
                d=matrix[n-j-1][i];
                matrix[j][n-i-1]=a;
                matrix[n-i-1][n-j-1]=b;
                matrix[n-j-1][i]=c;
                matrix[i][j]=d;
            }
        }
    }
}
