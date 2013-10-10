public class Solution {
    public int minPathSum(int[][] grid) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we can use dynamic programming
        // buffer[i][j] is the sum of the minimum path from [0][0]
        // obviously, buffer[i][j]=min(buffer[i-1][j],buffer[i][j-1])+grid[i][j]
        if (grid==null || grid.length<1 || grid[0]==null || grid[0].length<1)
        {
            return 0;
        }
        int [][]buffer=new int[grid.length][grid[0].length];
        int result=0;
        // initialization
        buffer[0][0]=grid[0][0];
        for (int i=1; i<grid.length; i++)
        {
            buffer[i][0]=buffer[i-1][0]+grid[i][0];
        }
        for (int j=1; j<grid[0].length; j++)
        {
            buffer[0][j]=buffer[0][j-1]+grid[0][j];
        }
        // progress
        for (int i=1; i<grid.length; i++)
        {
            for (int j=1; j<grid[i].length; j++)
            {
                buffer[i][j]=grid[i][j]+(buffer[i-1][j]<buffer[i][j-1]?buffer[i-1][j]:buffer[i][j-1]);
            }
        }
        return buffer[buffer.length-1][buffer[buffer.length-1].length-1];
    }
}
