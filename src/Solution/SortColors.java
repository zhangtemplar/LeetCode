package Solution;

import java.util.Arrays;

public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we just count how many objects are for each color
        if (A==null || A.length<1)
        {
            return;
        }
        int []count=new int[3];
        for (int i=0; i<A.length; i++)
        {
            count[A[i]]++;
        }
        Arrays.fill(A, 0, count[0], 0);
        Arrays.fill(A, count[0], count[1]+count[0], 1);
        Arrays.fill(A, count[0]+count[1], count[2]+count[1]+count[0], 2);
    }
}
