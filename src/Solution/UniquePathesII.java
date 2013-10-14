public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we use the same idea as previous one, except that, when A[i][j]=1, B[i][j]=0;
        if (obstacleGrid==null || obstacleGrid.length<1 || obstacleGrid[0]==null || obstacleGrid[0].length<1)
        {
            return 0;
        }
        int [][]result=new int[obstacleGrid.length][obstacleGrid[0].length];
        if (obstacleGrid[0][0]==1)
        {
            result[0][0]=0;
        }
        else
        {
            result[0][0]=1;
        }
        for (int i=1; i<obstacleGrid.length; i++)
        {
            if (obstacleGrid[i][0]==1)
            {
                result[i][0]=0;
            }
            else
            {
                result[i][0]=result[i-1][0];
            }
        }
        for (int j=1; j<obstacleGrid[0].length; j++)
        {
            if (obstacleGrid[0][j]==1)
            {
                result[0][j]=0;
            }
            else
            {
                result[0][j]=result[0][j-1];
            }
        }
        for (int i=1; i<obstacleGrid.length; i++)
        {
            for (int j=1; j<obstacleGrid[i].length; j++)
            {
                if (obstacleGrid[i][j]==1)
                {
                    result[i][j]=0;
                }
                else
                {
                    result[i][j]=result[i-1][j]+result[i][j-1];
                }
            }
        }
        return result[obstacleGrid.length-1][obstacleGrid[obstacleGrid.length-1].length-1];
    }
}
