package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NQueens instance=new NQueens();
		ArrayList<String[]> result=instance.solveNQueens(4);
		for (String[] strs: result)
		{
			for (String str: strs)
			{
				System.out.println(str);
			}
			System.out.println("\n\n");
		}
	}

	public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<0)
        {
            return new ArrayList<String[]>();
        }
        else if (n==1)
        {
            ArrayList<String[]> result=new ArrayList<String[]>();
            String[] strs={"Q"};
            result.add(strs);
            return result;
        }
        else
        {
            // for the other cases
            ArrayList<String[]> result=new ArrayList<String[]>();
            for (int i=0; i<n; i++)
            {
                String[] strs=new String[n];
                char[] str=new char[n];
                Arrays.fill(str, '.');
                str[i]='Q';
                strs[0]=new String(str);
                result.addAll(solveNQueens(0, strs));
            }
            return result;
        }
    }
    
    /**
     * this function finds the valid pattern given exsting result from 0-th to row-th row
     */
    private ArrayList<String[]> solveNQueens(int row, String[] strs)
    {
        ArrayList<String[]> result=new ArrayList<String[]>();
        if (row>=strs.length-1)
        {
            // we have finished
        	result.add(strs);
        }
        else
        {
            // try every possible position of current 
            for (int i=0; i<strs.length; i++)
            {
                if (isValid(strs, row+1, i))
                {
                    // this is valid solution
                    String []new_strs=(String [])Arrays.copyOf(strs, strs.length);
                    char []str=new char[strs.length];
                    Arrays.fill(str, '.');
                    str[i]='Q';
                    new_strs[row+1]=new String(str);
                    result.addAll(solveNQueens(row+1, new_strs));
                }
            }
        }
        return result;
    }
    
    // check whether current location is valid or not
    private boolean isValid(String []strs, int row, int col)
    {
        // check the same column
        for (int i=0; i<row; i++)
        {
            if (strs[i].charAt(col)=='Q')
            {
                return false;
            }
        }
        // check the \ diganoal
        for (int i=0; i<row; i++)
        {
            int j=col+i-row;
            if (j>=0 && j<strs.length && strs[i].charAt(j)=='Q')
            {
                return false;
            }
        }
        // check the / diganoal
        for (int i=0; i<row; i++)
        {
            int j=col+row-i;
            if (j>=0 && j<strs.length && strs[i].charAt(j)=='Q')
            {
                return false;
            }
        }
        return true;
    }
}
