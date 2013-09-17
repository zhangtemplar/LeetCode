package Solution;

public class UniquePathesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (obstacleGrid==null || obstacleGrid.length<1 || obstacleGrid[0]==null || obstacleGrid[0].length<1)
        {
            return 0;
        }
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int [][]result=new int[m][n];
        if (obstacleGrid[0][0]==1)
        {
            result[0][0]=0;
        }
        else
        {
            result[0][0]=1;
        }
        for (int i=1; i<m; i++)
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
        for (int j=1; j<n; j++)
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
        for (int i=1; i<m; i++)
        {
             for (int j=1; j<n; j++)
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
        return result[m-1][n-1];
    }
}
