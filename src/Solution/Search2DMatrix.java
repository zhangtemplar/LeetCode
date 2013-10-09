public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // this is a binary search problem
        if (matrix==null || matrix.length<1)
        {
            return false;
        }
        return searchMatrix(matrix, 0, matrix.length-1, target);
    }
    
    private boolean searchMatrix(int[][] matrix, int start, int end, int target)
    {
        if (start==end)
        {
            return searchMatrix(matrix[start], 0, matrix[start].length-1, target);
        }
        int middle=(start+end)/2;
        if (matrix[middle]==null || matrix[middle].length<1)
        {
            return false;
        }
        if (matrix[middle][0]>target)
        {
            if (middle==start)
            {
                return false;
            }
            else
            {
                return searchMatrix(matrix, start, middle-1, target);
            }
        }
        else if(matrix[middle][matrix[middle].length-1]<target)
        {
            return searchMatrix(matrix, middle+1, end, target);
        }
        else
        {
            return searchMatrix(matrix[middle], 0, matrix[middle].length-1, target);
        }
    }
    
    private boolean searchMatrix(int[] matrix, int start, int end, int target)
    {
        if (start==end)
        {
            return matrix[start]==target;
        }
        int middle=(start+end)/2;
        if (matrix[middle]==target)
        {
            return true;
        }
        else if (matrix[middle]>target)
        {
            if (middle==start)
            {
                return false;
            }
            else
            {
                return searchMatrix(matrix, start, middle-1, target);
            }
        }
        else
        {
            return searchMatrix(matrix, middle+1, end, target);
        }
    }
}
