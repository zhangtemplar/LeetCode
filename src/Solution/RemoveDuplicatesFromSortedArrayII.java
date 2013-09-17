package Solution;

import java.util.HashMap;

public class RemoveDuplicatesFromSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use hashmap, where the key is the value and the value is frequence
        if (A==null || A.length<2)
        {
            return A.length;
        }
        HashMap<Integer, Integer> set=new HashMap<Integer, Integer>();
        int result=2;
        set.put(A[0], 1);
        if (A[0]==A[1])
        {
            set.put(A[0], 2);
        }
        else
        {
            set.put(A[1], 1);
        }
        // start the processing
        for (int i=2; i<A.length; i++)
        {
            if (!set.containsKey(A[i]))
            {
                // the result is not found
                A[result]=A[i];
                set.put(A[i], 1);
                result++;
            }
            else if (set.get(A[i])<2)
            {
                // the result is only found once
                set.put(A[i], set.get(A[i])+1);
                A[result]=A[i];
                result++;
            }
            // the result is found more than twice
        }
        return result;
    }
}
