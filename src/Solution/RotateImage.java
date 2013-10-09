public class Solution {
    public void rotate(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the function is [x,y]->[n-y,x]
        if (matrix==null || matrix.length<1)
        {
            return;
        }
        int n=matrix.length;
        int a=0;
        int b=0;
        int c=0;
        int d=0;
        for (int i=0; i<(n+1)/2; i++)
        {
            for (int j=0; j<n/2; j++)
            {
                a=matrix[i][j];
                b=matrix[j][n-i-1];
                c=matrix[n-i-1][n-j-1];
                d=matrix[n-j-1][i];
                matrix[i][j]=d;
                matrix[j][n-i-1]=a;
                matrix[n-i-1][n-j-1]=b;
                matrix[n-j-1][i]=c;
            }
        }
    }
}
