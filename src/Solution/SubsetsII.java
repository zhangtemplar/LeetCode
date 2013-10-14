public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we shall use recursion
        // Say s(A[1: n]) is the subset of element with A[1: n], then the subset with {A[1: n] U B}
        // would be S(A[1: n]) U B U (S(A[1: n]xB)
        if (num==null || num.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        // sort
        Arrays.sort(num);
        return subsetsWithDup(num, num.length-1);
    }
    
    private ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num, int end)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (end==0)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(num[end]);
            result.add(entry);
            entry=new ArrayList<Integer>();
            result.add(entry);
        }
        else
        {
            ArrayList<ArrayList<Integer>> base=subsetsWithDup(num, end-1);
            // we will use hashset to remove the duplicate
            HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
            for (ArrayList<Integer> element: base)
            {
                set.add(element);
                ArrayList<Integer> entry=new ArrayList<Integer>(element);
                entry.add(num[end]);
                set.add(entry);
            }
            result.addAll(set);
        }
        return result;
    }
}
