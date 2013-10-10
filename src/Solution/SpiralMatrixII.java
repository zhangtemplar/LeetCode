public class Solution {
    public int[][] generateMatrix(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (n<1)
        {
            return new int[0][0];
        }
        int round=n/2;
        int [][]result=new int[n][n];
        int k=1;
        for (int i=0; i<round; i++)
        {
            // left to right
            for (int j=i; j<n-i-1; j++)
            {
                result[i][j]=k++;
            }
            // top to down
            for (int j=i; j<n-i-1; j++)
            {
                result[j][n-i-1]=k++;
            }
            // right to left
            for (int j=n-i-1; j>i; j--)
            {
                result[n-i-1][j]=k++;
            }
            // bottom to top
            for (int j=n-i-1; j>i; j--)
            {
                result[j][i]=k++;
            }
        }
        // for the center
        if (2*round!=n)
        {
            result[round][round]=k;
        }
        return result;
    }
}
