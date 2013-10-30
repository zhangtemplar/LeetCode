public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return result;
        }
        int round=Math.min(matrix.length, matrix[0].length)/2;
        for (int i=0; i<round; i++)
        {
            // left to right
            for (int j=i; j<matrix[i].length-i-1; j++)
            {
                result.add(matrix[i][j]);
            }
            // top to bottom
            for(int j=i; j<matrix.length-i-1; j++)
            {
                result.add(matrix[j][matrix[j].length-i-1]);
            }
            // right to left
            for (int j=matrix[matrix.length-i-1].length-1-i; j>i; j--)
            {
                result.add(matrix[matrix.length-i-1][j]);
            }
            // bottom to top
            for (int j=matrix.length-i-1; j>i; j--)
            {
                result.add(matrix[j][i]);
            }
        }
        // post-processing, we will have some element unprocessed
        // this only happens the row and column is not even and equal
        if (round*2!=matrix.length && round*2!=matrix[0].length)
        {
            // top to bottom
            if (matrix.length<matrix[0].length)
            {
                for (int j=round; j<matrix[round].length-round; j++)
                {
                    result.add(matrix[round][j]);
                }
            }
            else
            {
                for (int j=round; j<matrix.length-round; j++)
                {
                    result.add(matrix[j][round]);
                }
            }
        }
        return result;
    }
}
