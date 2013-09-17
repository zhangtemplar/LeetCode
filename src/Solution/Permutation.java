package Solution;

import java.util.ArrayList;
import java.util.HashSet;

public class Permutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // permute(num[i: end])=union(insert(num[i] to permute(num[i+1:j])
        if (num==null || num.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        HashSet<ArrayList<Integer>> result=permute(num, 0);
        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>(result);
        return arr;
    }
    
    private HashSet<ArrayList<Integer>> permute(int[] num, int start)
    {
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        if (start>=num.length)
        {
            return result;
        }
        else if (start==num.length-1)
        {
            // base
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(num[start]);
            result.add(entry);
            return result;
        }
        else
        {
            HashSet<ArrayList<Integer>> base=permute(num, start+1);
            // insert then before
            for (ArrayList<Integer> entry: base)
            {
                ArrayList<Integer> new_entry;
                for (int i=0; i<=entry.size(); i++)
                {
                    new_entry=new ArrayList<Integer>(entry);
                    new_entry.add(i, num[start]);
                    result.add(new_entry);
                }
            }
            return result;
        }
    }
}
