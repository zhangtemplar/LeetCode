package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we still use recursion
        // subsets(S[0:n])=S[n-1] U {subsets(S[0:n-1] x S[n-1]} U subsets(S[0:n-1]
        if (num==null || num.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(num);
        return new ArrayList<ArrayList<Integer>>(subsetsWithDup(num, num.length-1));
    }
    
    private HashSet<ArrayList<Integer>> subsetsWithDup(int[] S, int n)
    {
        // the algorithm is the similar as the previous one
        // except that, we will need hashset instead of ArrayList to reove duplicate
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        if (n<0)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            result.add(entry);
            return result;
        }
        else
        {
            HashSet<ArrayList<Integer>> base=subsetsWithDup(S, n-1);
            for (ArrayList<Integer> entry: base)
            {
                // we don't need to consider the duplicate here
                result.add(entry);
            }
            for (ArrayList<Integer> entry: base)
            {
                ArrayList<Integer> new_entry=new ArrayList<Integer>(entry);
                new_entry.add(S[n]);
                // check the duplication
                if (!result.contains(new_entry))
                {
                    result.add(new_entry);
                }
            }
            return result;
        }
    }
}
