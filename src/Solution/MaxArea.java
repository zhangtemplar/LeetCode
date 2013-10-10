public class Solution {
    public int maxArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // with exhaustive search, we have an algorithm of square complexity
        // we should have a linear algorithm
        if (height==null || height.length<2)
        {
            return 0;
        }
        int result=0;
        // we will search from both left and right
        // if the a[left]<a[right], the only possbility of better result is left++, otherwise right--
        int i=0;
        int j=height.length-1;
        while(i<j)
        {
            int volume=(j-i)*(height[i]<height[j]?height[i]:height[j]);
            if (result<volume)
            {
                result=volume;
            }
            if (height[i]<height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
        }
        return result;
    }
}
