package Solution;

import java.util.HashSet;
import java.util.ArrayList;

public class Combinations {

	private static final int ArrayList = 0;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Combinations instance=new Combinations();
		System.out.println(instance.combine(4, 2));
	}

	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion
        if (k<1 || n<1 || k>n)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        return new ArrayList<ArrayList<Integer>>(subCombine(n,k));
    }
    
    private HashSet<ArrayList<Integer>> subCombine(int n, int k)
    {
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        if (k==n)
        {
            java.util.ArrayList<Integer> entry=new ArrayList<Integer>();
            for (int i=1; i<=n; i++)
            {
                entry.add(i);
            }
            result.add(entry);
            return result;
        }
        else
        {
            HashSet<ArrayList<Integer>> base=subCombine(n, k+1);
            for (ArrayList<Integer> entry: base)
            {
                for (int j=0; j<entry.size(); j++)
                {
                    ArrayList<Integer> new_entry=new ArrayList<Integer>();
                    for (int i=0; i<entry.size(); i++)
                    {
                        if (i!=j)
                        {
                            new_entry.add(entry.get(i));
                        }
                    }
                    result.add(new_entry);
                }
            }
            return result;
        }
    }
}
