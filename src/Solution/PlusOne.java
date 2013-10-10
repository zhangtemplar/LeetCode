public class Solution {
    public int[] plusOne(int[] digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // note that, the size of the output could be one more than the input
        // we assume the number is stored such that higher bit is stored first
        int []result;
        if (digits==null || digits.length<1)
        {
            result=new int[1];
            result[0]=1;
        }
        result=new int[digits.length];
        int increment=1;
        for (int i=digits.length-1; i>=0; i--)
        {
            int val=digits[i]+increment;
            result[i]=val%10;
            increment=val/10;
        }
        if (increment!=0)
        {
            // we have an extra digit to fit in
            result=new int[digits.length+1];
            result[0]=1;
        }
        return result;
    }
}
