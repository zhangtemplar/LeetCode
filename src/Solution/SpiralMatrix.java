package Solution;

import java.util.ArrayList;

public class SpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpiralMatrix instance=new SpiralMatrix();
		int [][]arr={{6,9,7}};
		ArrayList<Integer> result=instance.spiralOrder(arr);
		System.out.println(result);
	}

	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function\
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return result;
        }
        int m=matrix.length;
        int n=matrix[0].length;
        int spiral=(m/2)>(n/2)?(n/2):(m/2);
        // the main algorithm
        // this should work with the case m is even
        int i;
        for (i=0; i<spiral; i++)
        {
            // for left-right
            for (int j=i; j<n-i-1; j++)
            {
                result.add(matrix[i][j]);
            }
            // for top-down
            for (int j=i; j<m-i-1; j++)
            {
                result.add(matrix[j][n-i-1]);
            }
            // for right-left
            for (int j=n-i-1; j>i; j--)
            {
                result.add(matrix[m-i-1][j]);
            }
            // for bottom-top
            for (int j=m-i-1; j>i; j--)
            {
                result.add(matrix[j][i]);
            }
        }
        // post-processing, check the special case, where m is odd
        if (n==1 || m==1)
        {
            for (i=0; i<m; i++)
            {
                for (int j=0; j<n; j++)
                {
                    result.add(matrix[i][j]);
                }
            }
        }
        else if(n<m && n%2>0)
        {
        	for (int j=i; j<=m-i-1; j++)
            {
                result.add(matrix[j][i]);
            }
        }
        else if(m<=n && m%2>0)
        {
        	// we have one row left out
            for (int j=i; j<=n-i-1; j++)
            {
                result.add(matrix[i][j]);
            }
        }
        return result;
    }
}
