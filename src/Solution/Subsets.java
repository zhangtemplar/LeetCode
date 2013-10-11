public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (S==null || S.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(S);
        return subsets(S, S.length-1);
    }
    
    private ArrayList<ArrayList<Integer>> subsets(int[] S, int end)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (end==0)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(S[end]);
            result.add(entry);
            entry=new ArrayList<Integer>();
            result.add(entry);
        }
        else
        {
            ArrayList<ArrayList<Integer>> base=subsets(S, end-1);
            result.addAll(base);
            ArrayList<Integer> entry=null;
            for (ArrayList<Integer> element: base)
            {
                entry=new ArrayList<Integer>(element);
                entry.add(S[end]);
                result.add(entry);
            }
        }
        return result;
    }
}
