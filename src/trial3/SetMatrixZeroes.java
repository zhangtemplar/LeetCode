package trial3;

public class SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * the idea is that, we will use the first row and column to store whether it will be zeroed
     * we then set the value for the matrix execept the first row and column
     * we then set the first row and column according to matrix[0][0]
     */
    public void setZeroes(int[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // null matrix
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return;
        }
        // singleton matrix
        if (matrix.length==1 && matrix[0].length==1)
        {
            return;
        }
        // normal cases
        // for first row/column, save it to matrix[0][0]
        boolean row=false;
        boolean col=false;
        for (int i=0; i<matrix.length; i++)
        {
            if (matrix[i][0]==0)
            {
                row=true;
                break;
            }
        }
        for(int j=0; j<matrix[0].length; j++)
        {
            if (matrix[0][j]==0)
            {
                col=true;
                break;
            }
        }
        // check each row
        for (int i=1; i<matrix.length; i++)
        {
            for(int j=1; j<matrix[i].length; j++)
            {
                if (matrix[i][j]==0)
                {
                    matrix[i][0]=0;
                    break;
                }
            }
        }
        // each column
        for(int j=1; j<matrix[0].length; j++)
        {
            for (int i=1; i<matrix.length; i++)
            {
                if (matrix[i][j]==0)
                {
                    matrix[0][j]=0;
                    break;
                }
            }
        }
        // set value
        for (int i=1; i<matrix.length; i++)
        {
            if (matrix[i][0]!=0)
            {
                continue;
            }
            for(int j=1; j<matrix[i].length; j++)
            {
                matrix[i][j]=0;
            }
        }
        for(int j=1; j<matrix[0].length; j++)
        {
            if (matrix[0][j]!=0)
            {
                continue;
            }
            for (int i=1; i<matrix.length; i++)
            {
                matrix[i][j]=0;
            }
        }
        // for the first row and column
        if (row)
        {
            for (int i=0; i<matrix.length; i++)
            {
                matrix[i][0]=0;
            }
        }
        if (col)
        {
            for(int j=0; j<matrix[0].length; j++)
            {
                matrix[0][j]=0;
            }
        }
    }
}
