public class Solution {
    public double pow(double x, int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // O(log(n))
        if (n==0)
        {
            return 1;
        }
        else if(n==1)
        {
            return x;
        }
        else if(n==-1)
        {
            return 1/x;
        }
        else
        {
            double y=pow(x, n/2);
            return y*y*pow(x, n-(n/2)*2);
        }
    }
}
