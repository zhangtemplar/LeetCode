package trial3;

import java.util.ArrayList;
import java.util.HashSet;

public class Combinations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * say s(n,k) is the set
     * then we have s(n,k)=insert(s(n,k-1))
     */
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (n<0 || k<0 || n<k)
        {
            return result;
        }
        HashSet<HashSet<Integer>> data=subCombine(n, k);
        for(HashSet<Integer> element: data)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>(element);
            result.add(entry);
        }
        return result;
    }
    
    private HashSet<HashSet<Integer>> subCombine(int n, int k)
    {
        HashSet<HashSet<Integer>> result=new HashSet<HashSet<Integer>>();
        if (k<=0)
        {
            HashSet<Integer> entry=new HashSet<Integer>();
            result.add(entry);
        }
        else if (k==n)
        {
            HashSet<Integer> entry=new HashSet<Integer>();
            for (int i=1; i<=n; i++)
            {
                entry.add(i);
            }
            result.add(entry);
        }
        else if (k<=n/2)
        {
            HashSet<HashSet<Integer>> base=subCombine(n, k-1);
            for (HashSet<Integer> element: base)
            {
                for (int i=1; i<=n; i++)
                {
                    if (element.contains(i))
                    {
                        continue;
                    }
                    HashSet<Integer> entry=new HashSet<Integer>(element);
                    entry.add(i);
                    result.add(entry);
                }
            }
        }
        else
        {
            HashSet<HashSet<Integer>> base=subCombine(n, k+1);
            for (HashSet<Integer> element: base)
            {
                for (int i=1; i<=n; i++)
                {
                    if (element.contains(i))
                    {
                        HashSet<Integer> entry=new HashSet<Integer>(element);
                        entry.remove(i);
                        result.add(entry);
                    }
                }
            }
        }
        return result;
    }
}
