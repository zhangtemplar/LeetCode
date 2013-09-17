package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={-1, 0, 1, 2, -1, -4};
		ArrayList<ArrayList<Integer>> result=threeSum(arr);
		for (ArrayList<Integer> x: result)
		{
			System.out.print("(");
			for (Integer y: x)
			{
				System.out.print(y+",");
			}
			System.out.println(")");
		}
	}

	public static ArrayList<ArrayList<Integer>> threeSum(int[] num)
	{
		ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> table=new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> triple=null;
        if (num==null || num.length<3)
        {
			return result;
		}
		Arrays.sort(num);
		for (int i=0; i<num.length-2; i++)
		{
			for (int j=i+1; j<num.length-1; j++)
			{
				int k=Arrays.binarySearch(num, j+1, num.length, -num[i]-num[j]);
				// since we start from the left, we should have already consider the triple with numbers before j
				if (k>j)
				{
					// we found the result
					// we still need to check the duplication
					// add the result in
					triple=new ArrayList<Integer>();
					triple.add(num[i]);
					triple.add(num[j]);
					triple.add(num[k]);
					if (!table.contains(triple))
    				{
						table.add(triple);
						result.add(triple);
					}
				}
			}
		}
		return result;
	}
}
