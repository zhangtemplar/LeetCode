public class Solution {
    public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the idea is that, if column i has 0, we set matrix[0][i]=0, if row i has 0, we set matrix[i][0]=0;
        // in addition, we use two flags to mark whether the row 0/col 0 has zero or not
        // note that, if column i has 0, matrix[0][i] will be set to zero anyhow
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return;
        }
        // we first save the first row and first column
        boolean row_0=false;
        for (int j=0; j<matrix[0].length; j++)
        {
            if (matrix[0][j]==0)
            {
                row_0=true;
                break;
            }
        }
        boolean col_0=false;
        for (int i=0; i<matrix.length; i++)
        {
            if (matrix[i][0]==0)
            {
                col_0=true;
                break;
            }
        }
        // mark the columns
        for (int i=1; i<matrix.length; i++)
        {
            for (int j=1; j<matrix[i].length; j++)
            {
                if (matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        // set the rows
        for (int i=1; i<matrix.length; i++)
        {
            if (matrix[i][0]==0)
            {
                for (int j=1; j<matrix[i].length; j++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        // set the columns
        for (int j=1; j<matrix[0].length; j++)
        {
            if (matrix[0][j]==0)
            {
                for (int i=1; i<matrix.length; i++)
                {
                    matrix[i][j]=0;
                }
            }
        }
        // for the first row and column
        if (row_0==true)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
                matrix[0][j]=0;
            }
        }
        if (col_0==true)
        {
            for (int i=0; i<matrix.length; i++)
            {
                matrix[i][0]=0;
            }
        }
    }
}
