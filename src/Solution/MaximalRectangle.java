package Solution;

public class MaximalRectangle {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][]matrix={{'0', '0', '0', '1', '0', '1', '1', '1'},
			{'0', '1', '1', '0', '0', '1', '0', '1'},
			{'1', '0', '1', '1', '1', '1', '0', '1'},
			{'0', '0', '0', '1', '0', '0', '0', '0'},
			{'0', '0', '1', '0', '0', '0', '1', '0'},
			{'1', '1', '1', '0', '0', '1', '1', '1'},
			{'1', '0', '0', '1', '1', '0', '0', '1'},
			{'0', '1', '0', '0', '1', '1', '0', '0'},
			{'1', '0', '0', '1', '0', '0', '0', '0'}};
		MaximalRectangle instance=new MaximalRectangle();
		System.out.println(instance.maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we need to use the algorithm from the "largest rectangle in histogram" to sovle
        // this problem
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return 0;
        }
        // we will create a table, which stores the number of continus row for the row
        // starting at this position
        int [][]table=new int[matrix.length][matrix[0].length];
        for (int i=matrix.length-1; i>=0; i--)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
                if (matrix[i][j]=='0')
                {
                    table[i][j]=0;
                }
                else if (i==matrix.length-1)
                {
                    table[i][j]=1;
                }
                else
                {
                    table[i][j]=table[i+1][j]+1;
                }
            }
        }
        // then for each row, we will apply algorithm "largest rectangle in histogram"
        // and save which ever is the largest
        int max_area=0;
        LargestRectangleInHistogram instance=new LargestRectangleInHistogram();
        for (int i=0; i<matrix.length; i++)
        {
            int area=instance.largestRectangleArea(table[i]);
            if (area>max_area)
            {
                max_area=area;
            }
        }
        return max_area;
    }
}
