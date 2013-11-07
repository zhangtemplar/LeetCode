public class Solution {
    public int atoi(String str) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (str==null || str.length()<1)
        {
            return 0;
        }
        long result=0;
        // skip the whitespace in the beginning
        int i=0;
        while(i<str.length())
        {
            if (str.charAt(i)!=' ')
            {
                break;
            }
            i++;
        }
        if (i>=str.length())
        {
            return 0;
        }
        // check the sign
        int sign=1;
        if (str.charAt(i)=='-')
        {
            sign=-1;
            i++;
        }
        else if(str.charAt(i)=='+')
        {
            i++;
        }
        while(i<str.length())
        {
            // digits found
            if (str.charAt(i)>='0' && str.charAt(i)<='9')
            {
                result=result*10+(str.charAt(i)-'0');
                // check the overflow
                if (sign>0 && result>=Integer.MAX_VALUE)
                {
                    return Integer.MAX_VALUE;
                }
                else if(sign<0 && -result<=Integer.MIN_VALUE)
                {
                    return Integer.MIN_VALUE;
                }
                // so far so good
                i++;
            }
            // invalid input found
            else
            {
                break;
            }
        }
        return (int)(sign*result);
    }
}
