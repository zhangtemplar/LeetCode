public class Solution {
    public void nextPermutation(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we find the rightmost element, which is smaller than its next right element
        // if this element dosen't exist, it means the arrangement is no possible
        if (num==null || num.length<2)
        {
            return;
        }
        int target=0;
        for (target=num.length-2; target>=0; target--)
        {
            if(num[target]<num[target+1])
            {
                break;
            }
        }
        // such arrangement is not possible, we just sort the array in ascending order
        if (target<0)
        {
            Arrays.sort(num);
            return;
        }
        // otherwise, we do the following
        // then sort from target+1
        Arrays.sort(num, target+1, num.length);
        // swap the target with the smallest element larger than it
        int i=0;
        for (i=target+1; i<num.length; i++)
        {
            if (num[i]>num[target])
            {
                break;
            }
        }
        int swap=num[target];
        num[target]=num[i];
        num[i]=swap;
    }
}
