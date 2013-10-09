public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion permute(num) can be built by insert num to every possible location of each entry in permute(num-1)
        if (num==null || num.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(num);
        return permute(num, num.length-1);
    }
    
    private ArrayList<ArrayList<Integer>> permute(int[] num, int end) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion permute(num) can be built by insert num to every possible location of each entry in permute(num-1)
        ArrayList<ArrayList<Integer>> result=null;
        if (end<0)
        {
            result=new ArrayList<ArrayList<Integer>>();
        }
        else if(end==0)
        {
            result=new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(num[end]);
            result.add(entry);
        }
        else
        {
            result=new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> base=permute(num, end-1);
            ArrayList<Integer> entry=null;
            for (ArrayList<Integer> element: base)
            {
                for (int i=0; i<=end; i++)
                {
                    entry=new ArrayList<Integer>(element);
                    entry.add(i, num[end]);
                    result.add(entry);
                }
            }
        }
        return result;
    }
}
