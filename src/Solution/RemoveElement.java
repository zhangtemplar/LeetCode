package Solution;

public class RemoveElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the first available lot and also the length of array
        int count=0;
        if (A==null || A.length<1)
        {
            return count;
        }
        for (int i=0; i<A.length; i++)
        {
            if (A[i]!=elem)
            {
                A[count++]=A[i];
            }
        }
        return count;
    }
}
