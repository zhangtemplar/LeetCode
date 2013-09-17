package Solution;

public class MaxArea {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public static int maxArea(int[] height) {
		// Start typing your Java solution below
        // DO NOT write main() function
        if (height==null || height.length<2)
        {
            return 0;
        }
        // we search for each pair of data points and keep the maximal
        // this algorithm has complexity O(n^2)
        /*
        int volume=0;
        for (int i=0; i<height.length; i++)
        {
            for (int j=height.length-1; j>i; j--)
            {
                int val=(j-i)*(height[i]>height[j]?height[j]:height[i]);
                if (val>volume)
                {
                    volume=val;
                }
            }
        }
        */
        // try a new one
        // this one should be have complexity O(n)
        int volume=0;
        int i, j;
        i=0;
        j=height.length-1;
        while(i<j)
        {
            int val=(j-i)*(height[i]>height[j]?height[j]:height[i]);
            if (val>volume)
            {
                volume=val;
            }
            if (height[j]<height[i])
            {
                // since height[j] is the shorter one, so our best chance is 
                // try the other one to increase it
                j--;
            }
            else
            {
                // all other case
                i++;
            }
        }
        return volume;
    }
}
