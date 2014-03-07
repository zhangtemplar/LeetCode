package trial3;

import java.util.ArrayList;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
     * n is also the the maximal number of columns
     * we only need to store the sum of (previous) one row
     */
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if (triangle==null || triangle.size()<1)
        {
            return 0;
        }
        ArrayList<Integer> prevSum=new ArrayList<Integer>(triangle.get(0));
        for (int i=1; i<triangle.size(); i++)
        {
            ArrayList<Integer> currSum=new ArrayList<Integer>(triangle.get(i).size());
            currSum.add(prevSum.get(0)+triangle.get(i).get(0));
            for (int j=0; j<prevSum.size()-1; j++)
            {
                currSum.add(Math.min(prevSum.get(j), prevSum.get(j+1))+triangle.get(i).get(j+1));
            }
            currSum.add(prevSum.get(prevSum.size()-1)+triangle.get(i).get(triangle.get(i).size()-1));
            
            prevSum=currSum;
        }
        
        int result=prevSum.get(0);
        for (int x: prevSum)
        {
            if (result>x)
            {
                result=x;
            }
        }
        return result;
    }
}
