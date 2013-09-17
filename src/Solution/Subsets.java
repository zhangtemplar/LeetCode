package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Subsets instance=new Subsets();
		int []S={1, 2, 3};
		System.out.println(instance.subsets(S));
	}

	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we still use recursion
        // subsets(S[0:n])=S[n-1] U {subsets(S[0:n-1] x S[n-1]} U subsets(S[0:n-1]
        if (S==null || S.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(S);
        return subsets(S, S.length-1);
    }
    
    private ArrayList<ArrayList<Integer>> subsets(int[] S, int n)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (n<0)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            result.add(entry);
            return result;
        }
        else
        {
            ArrayList<ArrayList<Integer>> base=subsets(S, n-1);
            for (ArrayList<Integer> entry: base)
            {
                result.add(entry);
            }
            for (ArrayList<Integer> entry: base)
            {
                ArrayList<Integer> new_entry=new ArrayList<Integer>(entry);
                new_entry.add(S[n]);
                result.add(new_entry);
            }
            return result;
        }
    }
}
