package Solution;

import java.util.ArrayList;

public class PascalTriangleII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (rowIndex<0)
        {
            return result;
        }
        else if(rowIndex==0)
        {
            result.add(1);
            return result;
        }
        else
        {
            ArrayList<Integer> base=new ArrayList<Integer>();
            base.add(1);
            result=new ArrayList<Integer>();
            for (int i=1; i<=rowIndex; i++)
            {
                result.add(1);
                for (int j=1; j<i; j++)
                {
                    result.add(base.get(j-1)+base.get(j));
                }
                result.add(2);
                base=result;
            }
            return result;
        }
    }
}
