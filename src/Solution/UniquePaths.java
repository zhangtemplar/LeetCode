public class Solution {
    public int uniquePaths(int m, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // dynamic programming
        if (m<1 || n<1)
        {
            return 0;
        }
        int [][]buffer=new int[m][n];
        // initialization
        for (int i=m-1; i>=0; i--)
        {
            buffer[i][n-1]=1;
        }
        for (int j=n-1; j>=0; j--)
        {
            buffer[m-1][j]=1;
        }
        // progress
        for (int i=m-2; i>=0; i--)
        {
            for (int j=n-2; j>=0; j--)
            {
                buffer[i][j]=buffer[i+1][j]+buffer[i][j+1];
            }
        }
        return buffer[0][0];
    }
}
