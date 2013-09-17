package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CombineSumUnqiue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num={10,1,2,7,6,1,5};
		CombineSumUnqiue instance=new CombineSumUnqiue();
		ArrayList<ArrayList<Integer>> result=instance.combinationSum(num, 8);
		for (ArrayList<Integer> entry: result)
		{
			for (int i: entry)
			{
				System.out.print(i+",");
			}
			System.out.println();
		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can use dynamic programming, i.e., we need to build a buffer for any target we have met before
        // check the input
        if (candidates==null || candidates.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        // sort the list
        Arrays.sort(candidates);
        // apply the algorithm
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for (int i=candidates.length-1; i>=0; i--)
        {
            result.addAll(combinationSum(candidates, i, target));
        }
        // remove duplication
        HashSet<ArrayList<Integer>> set=new HashSet<ArrayList<Integer>>(result);
        result=new ArrayList<ArrayList<Integer>>(set);
        return result;
    }
    
    // the buffer, where key is the target and value is its corresponding arraylist
    // we have difficulty in handling the buffer
//    private static HashMap<Integer, ArrayList<ArrayList<Integer>>> buffer=new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
    
    // end indicates the index of maximal number we already use
    // thus we can only use number no larger than it
    private HashSet<ArrayList<Integer>> combinationSum(int[] num, int end, int target)
    {
        // check the buffer first
//        if (buffer.containsKey(target))
//        {
//            // luckily, we have it in the buffer
//            return new ArrayList<ArrayList<Integer>>(buffer.get(target));
//        }
        // base
        // num[end] is the solution
        if (target==num[end])
        {
        	HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
            ArrayList<Integer> entry=new ArrayList<Integer>();
            entry.add(num[end]);
            result.add(entry);
            // buffer.put(target+num[end], result);
            return result;
        }
        // other case
        // num[end] can't be used in the solution
        else if (target<num[end])
        {
            // we will have no solution for this case
            // e.g., candidates=[2 3], target=1
            return new HashSet<ArrayList<Integer>>();
        }
        else
        {
            // num[end] is part of the solution
        	HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
            // we try the number one of one
            for (int i=end-1; i>=0; i--)
            {
                // find the solution for its subcase
            	HashSet<ArrayList<Integer>> base=combinationSum(num, i, target-num[end]);
                result.addAll(base);
            }
//			buffer.put(target-num[end], result);
			// add the num[end] to the tail
            for(ArrayList<Integer> entry: result)
            {
                entry.add(num[end]);
            }
            return result;
        }
    }
}
