package Solution;

import java.util.Arrays;

public class NQueensII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueensII instance=new NQueensII();
		for (int i=0; i<100; i++)
		{
			System.out.println(i+":"+instance.totalNQueens(i));
		}
	}

	public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<0)
        {
            return 0;
        }
        else if (n==1)
        {
            return 1;
        }
        else
        {
            // for the other cases
            int result=0;
            int []strs=new int[n];
            for (int i=0; i<n; i++)
            {
                strs[0]=i;
                result+=solveNQueens(0, strs);
            }
            return result;
        }
    }
    
    /**
     * this function finds the valid pattern given exsting result from 0-th to row-th row
     */
    private int solveNQueens(int row, int[] strs)
    {
        int result=0;
        if (row>=strs.length-1)
        {
            // we have finished
            result++;
        }
        else
        {
            // try every possible position of current 
            for (int i=0; i<strs.length; i++)
            {
                if (isValid(strs, row+1, i))
                {
                    // this is valid solution
                    strs[row+1]=i;
                    result+=solveNQueens(row+1, strs);
                }
            }
        }
        return result;
    }
    
    // check whether current location is valid or not
    // we don't need to use the String[] anymore, instead 
    // we can use an integer array to store the position of Q in each row
    private boolean isValid(int []strs, int row, int col)
    {
        // check the same column
        for (int i=0; i<row; i++)
        {
            if (strs[i]==col)
            {
                return false;
            }
        }
        // check the \ diganoal
        for (int i=0; i<row; i++)
        {
            if (i+strs[i]==row+col)
            {
                return false;
            }
        }
        // check the / diganoal
        for (int i=0; i<row; i++)
        {
            if (i-strs[i]==row-col)
            {
                return false;
            }
        }
        return true;
    }
}
