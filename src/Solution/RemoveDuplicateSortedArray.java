package Solution;

public class RemoveDuplicateSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int count=0;
        if (A==null || A.length<1)
        {
            return count;
        }
        // the last distinct value we found
        int previous=A[0];
        // the first available place to fit in
        int last=1;
        count++;
        for (int i=1; i<A.length; i++)
        {
            if (A[i]!=previous)
            {
                // change the length
                count++;
                // change the distinct value
                previous=A[i];
                // save this value also
                A[last++]=previous;
            }
        }
        return count;
    }
}
