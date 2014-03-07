package trial3;

import java.util.ArrayList;

public class PascalTriangleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * we only need to store two adjacent rows
     */
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (rowIndex<0)
        {
            return result;
        }
        result.add(1);
        for (int i=1; i<=rowIndex; i++)
        {
            ArrayList<Integer> tmp=new ArrayList<Integer>();
            tmp.add(1);
            for (int j=1; j<i; j++)
            {
                tmp.add(result.get(j-1)+result.get(j));
            }
            tmp.add(1);
            
            result=tmp;
        }
        return result;
    }
}
