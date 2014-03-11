package trial3;

public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * bucket sort
     */
    public void sortColors(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (A==null || A.length<1)
        {
            return;
        }
        int red, white, blue;
        red=0;
        white=0;
        blue=0;
        for (int x: A)
        {
            if (x==0)
            {
                red++;
            }
            else if (x==1)
            {
                white++;
            }
            else
            {
                blue++;
            }
        }
        for(int i=0; i<A.length; i++)
        {
            if (red>0)
            {
                A[i]=0;
                red--;
            }
            else if (white>0)
            {
                A[i]=1;
                white--;
            }
            else
            {
                A[i]=2;
                blue--;
            }
        }
    }
}
