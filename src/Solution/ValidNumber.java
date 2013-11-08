public class Solution {
    public boolean isNumber(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null || s.length()<1)
        {
            return false;
        }
        // skip the empty space in the top
        int i=0;
        while(i<s.length() && s.charAt(i)==' ')
        {
            i++;
        }
        if (i>=s.length())
        {
            return false;
        }
        // skip the sign
        if (s.charAt(i)=='-' || s.charAt(i)=='+')
        {
            i++;
        }
        boolean before_e=false;
        boolean after_e=false;
        boolean found_e=false;
        boolean found_dot=false;
        boolean before_dot=false;
        boolean after_dot=false;
        while(i<s.length())
        {
            // nonnumeric
            if (s.charAt(i)<'0' || s.charAt(i)>'9')
            {
                // found sign and this is the first sign after e
                if ((s.charAt(i)=='-' || s.charAt(i)=='+') && found_e && s.charAt(i-1)=='e')
                {
                    //
                }
                // found e and no e found before
                else if (!found_e && before_e && s.charAt(i)=='e')
                {
                    found_e=true;
                }
                // found dot and no dot found before, also this dot should before e
                else if (!found_e & !found_dot && s.charAt(i)=='.')
                {
                    found_dot=true;
                }
                // found empty space again, then all the remaining should be empty space
                else if(s.charAt(i)==' ')
                {
                    // we found space, we need to check all the remaining is space
                    while(i<s.length() && s.charAt(i)==' ')
                    {
                        i++;
                    }
                    if ( i<s.length())
                    {
                        return false;
                    }
                }
                else
                {
                    return false;
                }
            }
            else 
            {
                if (found_e)
                {
                    after_e=true;
                }
                else
                {
                    before_e=true;
                }
                if (found_dot)
                {
                    after_dot=true;
                }
                else
                {
                    before_dot=true;
                }
            }
            i++;
        }
        if (found_e)
        {
            return after_e;
        }
        if (found_dot)
        {
            return after_dot || before_dot;
        }
        return true;
    }
}
