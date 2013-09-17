package Solution;

import java.util.ArrayList;

public class PascalTriangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PascalTriangle instance=new PascalTriangle();
		System.out.println(instance.generate(5));
	}

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (numRows<1)
        {
            return result;
        }
        for (int i=0; i<numRows; i++)
        {
            ArrayList<Integer> row=new ArrayList<Integer>();
            if (i==0)
            {
                row.add(1);
            }
            else
            {
                row.add(1);
                for (int j=1; j<i; j++)
                {
                    ArrayList<Integer> base=result.get(i-1);
                    row.add(base.get(j-1)+base.get(j));
                }
                row.add(1);
            }
            result.add(row);
        }
        return result;
    }
}
