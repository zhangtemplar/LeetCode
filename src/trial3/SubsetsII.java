package trial3;

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
	/**
     * say set(n) is the subset for num[0:n]
     * then set(n)=union{set(n-1), set(n-1)xnum[n]} with removal of duplicate
     */
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        if (num==null || num.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        Arrays.sort(num);
        return new ArrayList<ArrayList<Integer>>(subsetsWithDup(num, num.length-1));
    }
    
    private HashSet<ArrayList<Integer>> subsetsWithDup(int[] num, int start)
    {
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        if (start<0)
        {
            result.add(new ArrayList<Integer>());
        }
        else
        {
            HashSet<ArrayList<Integer>> base=subsetsWithDup(num, start-1);
            for (ArrayList<Integer> entry: base)
            {
                ArrayList<Integer> element=new ArrayList<Integer>(entry);
                element.add(num[start]);
                result.add(entry);
                result.add(element);
            }
        }
        return result;
    }
}
