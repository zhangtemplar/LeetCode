package Solution;

import java.util.Arrays;

public class TwoSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={2,1,9,4,4,56,90,3};
		int []result=twoSum(arr, 8);
	}

	/**
	 * one test case
	 * input					output	expected	
	 * [2,1,9,4,4,56,90,3], 8	4, 4	4, 5
	 * @param numbers
	 * @param target
	 * @return
	 */
    public static int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []result=new int[2];
        result[0]=0;
        result[1]=0;
        if (numbers==null || numbers.length<2)
        {
            return result;
        }
        // copy the array
        int []arr=numbers.clone();
        Arrays.sort(arr);
        int i, j;
        i=0;
        j=arr.length-1;
        int sum;
        while(i<j)
        {
            sum=arr[i]+arr[j];
            if (sum<target)
            {
                i++;
            }
            else if (sum>target)
            {
                j--;
            }
            else
            {
                // find the solution, we also assumes only one soultion there
                // we can't apply the binary search for orignal index due to unsorted
                if (arr[i]==arr[j])
                {
                    // in case there are indentical element in the array, we search from the next position
                    i=searchIndex(numbers, arr[i])+1;
                    j=searchIndex(numbers, arr[j], i)+1;
                }
                else
                {
                    i=searchIndex(numbers, arr[i])+1;
                    j=searchIndex(numbers, arr[j])+1;
                }
                result[0]=i>j?j:i;
                result[1]=i>j?i:j;
                break;
            }
        }
        return result;
    }
    
    /**
     * search in the whole array
     */
    public static int searchIndex(int [] arr, int value)
    {
        return searchIndex(arr, value, 0);
    }
    
    /**
     * search from the specific location (inclusive)
     */
    public static int searchIndex(int [] arr, int value, int offset)
    {
        int i=offset;
        for (; i<arr.length; i++)
        {
            if (arr[i]==value)
            {
                return i;
            }
        }
        return i;
    }
}
