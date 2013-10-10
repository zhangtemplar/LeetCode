public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // let's a(n, k) is the result, we can obtain a(n, k-1) from a(n, k) (k>1) by the following step
        // for each entry of a(n, k), we remove one of the element from the entry and create a new array
        // the complexity is |a(n, k)|*k
        // the base class a(n, n), a(n, 0)
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (n<k || k<0 || n<0)
        {
            return result;
        }
        else if (n==k)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            for (int i=1; i<=n; i++)
            {
                entry.add(i);
            }
            result.add(entry);
        }
        else
        {
            ArrayList<ArrayList<Integer>> base=combine(n, k+1);
            // we use hashset to remove the duplicate
            HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>();
            for (ArrayList<Integer> element: base)
            {
                // outer loop the element we want to remove
                for (int i=0; i<element.size(); i++)
                {
                    ArrayList<Integer> entry=new ArrayList<Integer>();
                    // inner loop, add in the other element one by one
                    for (int j=0; j<element.size(); j++)
                    {
                        if (i!=j)
                        {
                            entry.add(element.get(j));
                        }
                    }
                    set.add(entry);
                }
            }
            // save it to the array
            result.addAll(set);
        }
        return result;
    }
}
