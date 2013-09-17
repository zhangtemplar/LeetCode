package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

public class FourSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={-3,-2,-1,0,0,1,2,3};
		ArrayList<ArrayList<Integer>> result=fourSum(arr, 0);
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

	public static ArrayList<ArrayList<Integer>> fourSumSlow(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        HashSet<ArrayList<Integer>> table=new HashSet<ArrayList<Integer>>();
    	ArrayList<Integer> triple=null;
        if (num==null || num.length<3)
        {
			return result;
		}
		Arrays.sort(num);
		for (int i=0; i<num.length-3; i++)
		{
			for (int j=i+1; j<num.length-2; j++)
			{
                for (int l=j+1; l<num.length-1; l++)
                {
    				int k=Arrays.binarySearch(num, l+1, num.length, target-num[i]-num[j]-num[l]);
    				// since we start from the left, we should have already consider the triple with numbers before j
    				if (k>j)
    				{
    					// we found the result
    					// we still need to check the duplication
    					// add the result in
    					triple=new ArrayList<Integer>();
    					triple.add(num[i]);
    					triple.add(num[j]);
                        triple.add(num[l]);
    					triple.add(num[k]);
    					if (!table.contains(triple))
        				{
    						table.add(triple);
    						result.add(triple);
    					}
    				}
                }
			}
		}
		return result;
    }
	
	public static ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the obvious solution has complexity of O(n^3log(n))
        // where the log(n) comes from the binary search
        // however, there is faster version available there: 
        // We first compute the N^2 two sums, and sort the two sums.
        // The for each TwoSum t, we check whether there is another two sum t'
        // such that t.value + t'.value = target. The time complexity of this
        //approach is O(N^2 logN). 
        // we still starts at sorting the array
        Arrays.sort(num);
        // build the two sum
        SumTwo []sum_two=new SumTwo[num.length*(num.length-1)/2];
        int k=0;
        for (int i=0; i<num.length; i++)
        {
            for (int j=i+1; j<num.length; j++)
            {
            	sum_two[k++]=new SumTwo(i, j, num[i]+num[j]);
            }
        }
        // sort of sum_two
        Arrays.sort(sum_two);
        // from those two sum, we find the solution for the four sum
        HashSet<ArrayList<Integer>> table=new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        for (int i=0; i<sum_two.length-1; i++)
        {
            int l=Arrays.binarySearch(sum_two, i+1, sum_two.length, new SumTwo(-1, -1, target-sum_two[i].sum));
            // to make sure there is no collision there
            // i.e., no index is used more than once
            if (l<0)
        	{
            	// no match
            	continue;
        	}
            else
            {
            	// we need to check all the match
            	for (int j=l; j>=0 && sum_two[j].sum==sum_two[l].sum; j--)
            	{
	                if (!(sum_two[j].x==sum_two[i].x || sum_two[j].x==sum_two[i].y || sum_two[j].y==sum_two[i].x || sum_two[j].y==sum_two[i].y))
	                {
	                    // a solution is found
	                	ArrayList<Integer> quadruplet=new ArrayList<Integer>();
	                    // we also need to sort
	                    quadruplet.add(num[sum_two[i].x]>num[sum_two[j].x]?num[sum_two[j].x]:num[sum_two[i].x]);
	                    int max_x=num[sum_two[i].x]>num[sum_two[j].x]?num[sum_two[i].x]:num[sum_two[j].x];
	                    int min_y=num[sum_two[i].y]>num[sum_two[j].y]?num[sum_two[j].y]:num[sum_two[i].y];
	                    quadruplet.add(max_x>min_y?min_y:max_x);
	                    quadruplet.add(max_x>min_y?max_x:min_y);
	                    quadruplet.add(num[sum_two[i].y]>num[sum_two[j].y]?num[sum_two[i].y]:num[sum_two[j].y]);
	                    if (!table.contains(quadruplet))
	                    {
	                        table.add(quadruplet);
	                        result.add(quadruplet);
	                    }
	                }
            	}
            	for (int j=l+1; j<sum_two.length && sum_two[j].sum==sum_two[l].sum; j++)
            	{
	                if (!(sum_two[j].x==sum_two[i].x || sum_two[j].x==sum_two[i].y || sum_two[j].y==sum_two[i].x || sum_two[j].y==sum_two[i].y))
	                {
	                    // a solution is found
	                	ArrayList<Integer> quadruplet=new ArrayList<Integer>();
	                    // we also need to sort
	                    quadruplet.add(num[sum_two[i].x]>num[sum_two[j].x]?num[sum_two[j].x]:num[sum_two[i].x]);
	                    int max_x=num[sum_two[i].x]>num[sum_two[j].x]?num[sum_two[i].x]:num[sum_two[j].x];
	                    int min_y=num[sum_two[i].y]>num[sum_two[j].y]?num[sum_two[j].y]:num[sum_two[i].y];
	                    quadruplet.add(max_x>min_y?min_y:max_x);
	                    quadruplet.add(max_x>min_y?max_x:min_y);
	                    quadruplet.add(num[sum_two[i].y]>num[sum_two[j].y]?num[sum_two[i].y]:num[sum_two[j].y]);
	                    if (!table.contains(quadruplet))
	                    {
	                        table.add(quadruplet);
	                        result.add(quadruplet);
	                    }
	                }
            	}
            }
        }
        // sort the result
        Collections.sort(result, new QuadrupletComparator());
        return result;
    }
	
	private static class QuadrupletComparator implements Comparator<ArrayList<Integer>>
	{

		@Override
		public int compare(ArrayList<Integer> arg0, ArrayList<Integer> arg1) {
			// TODO Auto-generated method stub
			for (int i=0; i<4 && i<arg0.size() && i<arg1.size(); i++)
			{
				if (arg0.get(i)>arg1.get(i))
				{
					return 1;
				}
				else if  (arg0.get(i)<arg1.get(i))
				{
					return -1;
				}
			}
			return 0;
		}
		
	}
}

// to store the result
class SumTwo implements Comparable<SumTwo>
{
    public int x, y, sum;
    public SumTwo(int a, int b, int s)
    {
        x=a;
        y=b;
        sum=s;
    }
    
    public int compareTo(SumTwo s)
    {
        return sum-s.sum;
    }
    
    public String toString()
    {
    	return new String(x+"+"+y+"="+sum);
    }
}
