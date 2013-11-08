public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null)
        {
            return p==null;
        }
        else if(p==null)
        {
            return false;
        }
        int i=0;
        int j=0;
        int i_star=-1;
        int j_star=-1;
        while(i<s.length())
        {
            // if p is not long enough, we try to replace one more character of s by * in p, if there was one
            if (j>=p.length())
            {
                // we try to replace one more character of s by * in p, if there was one
                if (j_star>=0)
                {
                    i=++i_star;
                    j=j_star+1;
                }
                else
                {
                    break;
                }
            }
            // for *, we record its location and skip it
            else if (p.charAt(j)=='*')
            {
                i_star=i;
                j_star=j;
                j++;
            }
            // a match or ?
            else if(p.charAt(j)=='?' || p.charAt(j)==s.charAt(i))
            {
                i++;
                j++;
            }
            // a mismatch, however, we have a star somewhere back
            // we use * of p to replace one character of s
            else if (j_star>=0)
            {
                i=++i_star;
                j=j_star+1;
            }
            else
            {
                return false;
            }
        }
        // for the end, if p is not complete, we need to check whether it is only *
        while(j<p.length() && p.charAt(j)=='*')
        {
            j++;
        }
        if (j<p.length() || i<s.length())
        {
            return false;
        }
        return true;
    }
}
