package trial3;

import java.util.ArrayList;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (numRows<1)
        {
            return result;
        }
        ArrayList<Integer> prevRow=new ArrayList<Integer>();
        prevRow.add(1);
        result.add(prevRow);
        for (int i=1; i<numRows; i++)
        {
            ArrayList<Integer> currRow=new ArrayList<Integer>();
            currRow.add(1);
            for (int j=1; j<i; j++)
            {
                currRow.add(prevRow.get(j-1)+prevRow.get(j));
            }
            currRow.add(1);
            
            prevRow=currRow;
            result.add(prevRow);
        }
        return result;
    }
}
