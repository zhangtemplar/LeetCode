package Solution;

public class MinimumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minPathSum(int[][] grid) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // this is the minimum path problem for the graph
        if (grid==null || grid.length<1 || grid[0]==null || grid[0].length<1)
        {
            return 0;
        }
        int m=grid.length;
        int n=grid[0].length;
        int [][]result=new int[m][n];
        if(m==1 && n==1)
        {
            return grid[0][0];
        }
        result[0][0]=grid[0][0];
        for (int i=1; i<m; i++)
        {
            result[i][0]=result[i-1][0]+grid[i][0];
        }
        for (int j=1; j<n; j++)
        {
            result[0][j]=result[0][j-1]+grid[0][j];
        }
        for (int i=1; i<m; i++)
        {
             for (int j=1; j<n; j++)
             {
                 result[i][j]=(result[i-1][j]>result[i][j-1]?result[i][j-1]:result[i-1][j])+grid[i][j];
             }
        }
        return result[m-1][n-1];
    }
}
