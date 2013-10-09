public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we still use recursion
        // but we only store the result from getRow(rowIndex-1)
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (rowIndex==0)
        {
            result.add(1);
        }
        else if(rowIndex>0)
        {
            ArrayList<Integer> base=getRow(rowIndex-1);
            result.add(1);
            for (int i=1; i<base.size(); i++)
            {
                result.add(base.get(i-1)+base.get(i));
            }
            result.add(1);
        }
        return result;
    }
}
