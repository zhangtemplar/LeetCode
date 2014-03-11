package trial3;

public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * binary search
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return false;
        }
        return searchMatrix(matrix, target, 0, matrix.length-1, 0, matrix[0].length-1);
    }
    
    private boolean searchMatrix(int[][] matrix, int target, int beginRow, int endRow, int beginColumn, int endColumn)
    {
        // search in the row
        if (beginRow==endRow)
        {
            if (beginColumn==endColumn)
            {
                return matrix[beginRow][beginColumn]==target;
            }
            else
            {
                int middle=(beginColumn+endColumn)/2;
                if (matrix[beginRow][middle]==target)
                {
                    return true;
                }
                if (matrix[beginRow][middle]>target && middle>beginColumn && searchMatrix(matrix, target, beginRow, endRow, beginColumn, middle-1))
                {
                    return true;
                }
                if (matrix[beginRow][middle]<target && middle<endColumn && searchMatrix(matrix, target, beginRow, endRow, middle+1, endColumn))
                {
                    return true;
                }
                return false;
            }
        }
        else
        {
            int middle=(beginRow+endRow)/2;
            if (matrix[middle][matrix[middle].length-1]==target)
            {
                return true;
            }
            if (matrix[middle][matrix[middle].length-1]>target && searchMatrix(matrix, target, beginRow, middle, beginColumn, endColumn))
            {
                return true;
            }
            if (matrix[middle][matrix[middle].length-1]<target && middle<endRow && searchMatrix(matrix, target, middle+1, endRow, beginColumn, endColumn))
            {
                return true;
            }
            return false;
        }
    }
}
