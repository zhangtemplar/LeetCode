public class Solution {
    public boolean isPalindrome(int x) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the idea is simple, we build another number by reversing the digits of the input
        // if this number is equal to x, then it would be palindrome
        if (x<0)
        {
            return false;
        }
        // avoid overflow
        long y=(long) x;
        long w=y;
        long z=0;
        while(y>0)
        {
            z=z*10+y%10;
            y=y/10;
        }
        return z==w;
    }
}
