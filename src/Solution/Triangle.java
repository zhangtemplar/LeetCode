public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // # rows = max # column
        // we will process from top to bottom, compute the sum of minimum path from top to the current position
        if (triangle==null)
        {
            return 0;
        }
        ArrayList<Integer> prev=new ArrayList<Integer>();
        ArrayList<Integer> current=null;
        prev.add(triangle.get(0).get(0));
        for (int i=1; i<triangle.size(); i++)
        {
            current=new ArrayList<Integer>();
            current.add(triangle.get(i).get(0)+prev.get(0));
            for (int j=1; j<triangle.get(i).size()-1; j++)
            {
                current.add(Math.min(prev.get(j), prev.get(j-1))+triangle.get(i).get(j));
            }
            current.add(triangle.get(i).get(triangle.get(i).size()-1)+prev.get(prev.size()-1));
            prev=current;
        }
        // find the minimal
        int min=Integer.MAX_VALUE;
        for (int x: prev)
        {
            if (min>x)
            {
                min=x;
            }
        }
        return min;
    }
}
