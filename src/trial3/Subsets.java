package trial3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (S==null || S.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(S);
        return new ArrayList<ArrayList<Integer>>(subsets(S, S.length-1));
    }
    
    private HashSet<ArrayList<Integer>> subsets(int []S, int index)
    {
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        if (index<0)
        {
            ArrayList<Integer> entry=new ArrayList<Integer>();
            result.add(entry);
        }
        else
        {
            HashSet<ArrayList<Integer>> base=subsets(S, index-1);
            for (ArrayList<Integer> element: base)
            {
                ArrayList<Integer> entry=new ArrayList<Integer>(element);
                entry.add(S[index]);
                result.add(element);
                result.add(entry);
            }
        }
        return result;
    }
}
