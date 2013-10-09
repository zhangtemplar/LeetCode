public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // it is a recursion
        ArrayList<ArrayList<Integer>> result;
        if (numRows<1)
        {
            result=new ArrayList<ArrayList<Integer>>();
        }
        else if(numRows==1)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(1);
            result=new ArrayList<ArrayList<Integer>>();
            result.add(entry);
        }
        else
        {
            result=generate(numRows-1);
            ArrayList<Integer> entry=new ArrayList<Integer>();
            ArrayList<Integer> base=result.get(result.size()-1);
            entry.add(1);
            for (int i=1; i<base.size(); i++)
            {
                entry.add(base.get(i-1)+base.get(i));
            }
            entry.add(1);
            result.add(entry);
        }
        return result;
    }
}
