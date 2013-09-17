package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CombineSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num={2, 3, 6, 7};
		CombineSum instance=new CombineSum();
		ArrayList<ArrayList<Integer>> result=instance.combinationSum(num, 13);
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
        // remove the duplciate numbers
        int[] num=removeDuplicate(candidates);
        // apply the algorithm
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for (int i=num.length-1; i>=0; i--)
        {
            result.addAll(combinationSum(num, i, target));
        }
        return result;
    }
    
    private int[] removeDuplicate(int []num)
    {
        int i=0;
        int j=0;
        while(i<num.length)
        {
            if (num[j]==num[i])
            {
                i++;
            }
            else
            {
                num[++j]=num[i++];
            }
        }
        return Arrays.copyOf(num, j+1);
    }
    
    // the buffer, where key is the target and value is its corresponding arraylist
    // we have difficulty in handling the buffer
//    private static HashMap<Integer, ArrayList<ArrayList<Integer>>> buffer=new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
    
    // end indicates the index of maximal number we already use
    // thus we can only use number no larger than it
    private ArrayList<ArrayList<Integer>> combinationSum(int[] num, int end, int target)
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
            ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
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
            return new ArrayList<ArrayList<Integer>>();
        }
        else
        {
            // num[end] is part of the solution
            ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
            // we try the number one of one
            for (int i=end; i>=0; i--)
            {
                // find the solution for its subcase
                ArrayList<ArrayList<Integer>> base=combinationSum(num, i, target-num[end]);
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
