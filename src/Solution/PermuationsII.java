public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we first permuate the index, we then assign the index
        // we will use recursion
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (num==null || num.length<1)
        {
            return result;
        }
        else
        {
            Arrays.sort(num);
            return permuteUnique(num, num.length-1);
        }
    }
    
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num, int end)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (end==0)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(num[end]);
            result.add(entry);
        }
        else
        {
            ArrayList<ArrayList<Integer>> base=permuteUnique(num, end-1);
            HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
            ArrayList<Integer> entry=null;
            for (ArrayList<Integer> element: base)
            {
                // the insert location
                for (int i=0; i<=end; i++)
                {
                    entry=new ArrayList<Integer>();
                    // add the chars one by one
                    for (int j=0; j<i; j++)
                    {
                        entry.add(element.get(j));
                    }
                    entry.add(num[end]);
                    for (int j=i; j<end; j++)
                    {
                        entry.add(element.get(j));
                    }
                    set.add(entry);
                }
            }
            result.addAll(set);
        }
        return result;
    }
}
