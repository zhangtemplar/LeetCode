package Solution;

import java.util.ArrayList;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the algorithm is easy
        ArrayList<Integer> prev=new ArrayList<Integer>();
        ArrayList<Integer> current=new ArrayList<Integer>();
        if (triangle==null || triangle.size()<1)
        {
            return 0;
        }
        current.add(triangle.get(0).get(0));
        for (int l=1; l<triangle.size(); l++)
        {
            prev=current;
            current=new ArrayList<Integer>();
            current.add(prev.get(0)+triangle.get(l).get(0));
            for (int i=1; i<prev.size(); i++)
            {
                current.add(Math.min(prev.get(i-1), prev.get(i))+triangle.get(l).get(i));
            }
            current.add(prev.get(prev.size()-1)+triangle.get(l).get(triangle.get(l).size()-1));
        }
        // find the min of the last row
        int min=Integer.MAX_VALUE;
        for (int x: current)
        {
            if (min>x)
            {
                min=x;
            }
        }
        return min;
    }
}
