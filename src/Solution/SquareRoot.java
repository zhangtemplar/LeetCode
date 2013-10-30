public class Solution {
    public int sqrt(int x) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will use binary search
        if (x<=0)
        {
            return 0;
        }
        else if(x==1)
        {
            return 1;
        }
        long left=1;
        long right=x;
        long middle=(left+right)/2;
        while(left<right)
        {
            middle=(left+right)/2;
            if (middle*middle==x)
            {
                return (int)middle;
            }
            else if (middle*middle<x)
            {
                left=middle+1;
            }
            else 
            {
                right=middle;
            }
        }
        if (middle*middle>x)
        {
            return (int)(middle-1);
        }
        else
        {
            return (int)middle;
        }
    }
}
