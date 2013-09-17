package Solution;

public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can use a binary search
        // we first get the row index and then the column index
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return false;
        }
        int l_row=0;
        int u_row=matrix.length-1;
        int row=(matrix.length-1)/2;
        while(u_row>=l_row)
        {
            if (matrix[row][0]>target)
            {
                // search in row before it
                u_row=row-1;
                row=(u_row+l_row)/2;
            }
            else if(matrix[row][matrix[row].length-1]<target)
            {
                // search in row after it;
                l_row=row+1;
                row=(u_row+l_row)/2;
            }
            else
            {
                // we found the row
                break;
            }
        }
        int l_col=0;
        int u_col=matrix[row].length-1;
        int col=(u_col+l_col)/2;
        while(u_col>=l_col)
        {
            if(matrix[row][col]>target)
            {
                u_col=col-1;
                col=(u_col+l_col)/2;
            }
            else if(matrix[row][col]<target)
            {
                l_col=col+1;
                col=(u_col+l_col)/2;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}
