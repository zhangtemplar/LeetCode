package Solution;

import java.util.Arrays;

public class SetMatrixZero {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void setZeroes(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we set a flag to avoid duplicate operation
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return;
        }
        // first scane
        boolean[] flag_row=new boolean[matrix.length];
        boolean[] flag_col=new boolean[matrix[0].length];
        for (int i=0; i<matrix.length; i++)
        {
            // we have set this row to zero before
            for (int j=0; j<matrix[0].length; j++)
            {
                if(matrix[i][j]==0)
                {
                    flag_row[i]=true;
                    flag_col[j]=true;
                }
            }
        }
        // second scan
        for (int i=0; i<flag_row.length; i++)
        {
            if (flag_row[i])
            {
                Arrays.fill(matrix[i], 0);
            }
        }
        for (int j=0; j<flag_col.length; j++)
        {
            if (flag_col[j])
            {
                for (int i=0; i<flag_row.length; i++)
                {
                    matrix[i][j]=0;
                }
            }
        }
    }
}
