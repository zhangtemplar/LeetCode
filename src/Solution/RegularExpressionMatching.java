public class Solution {
    public boolean isMatch(String s, String p) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will use backtrace
        // however, we only backtrace to the last '*'
        if (s==null || s.length()<1)
        {
            if (p==null || p.length()<1)
            {
                return true;
            }
        }
        else if(p==null || p.length()<1)
        {
            return false;
        }
        // do the matching
        int i=0; 
        int j=0;
        int last_j=-1;
        int last_i=-1;
        while(i<s.length())
        {
            // we use up j, we just check whether we have *
            if (j>=p.length())
            {
                // we do have a *, we use this * to replance one more char in s
                if (last_j>=0)
                {
                    i=last_i+1;
                    j=last_j;
                }
                else
                {
                    break;
                }
            }
            // we keep a record of the last *, by default we skip it
            else if (p.charAt(j)=='*')
            {
                last_j=j;
                last_i=i;
                j++;
            }
            // a match
            else if (p.charAt(j)=='.' || p.charAt(j)==s.charAt(i))
            {
                i++;
                j++;
            }
            // a mismatch, but we have a '*'
            // so we replace everything from i of last_j to current i by *
            else if (last_j>=0)
            {
                j=last_j;
                i++;
            }
            else
            {
                // we just skip the unmatched head of p
                i=0;
                j++;
            }
        }
        // tail of s is not matched
        if (i<s.length())
        {
            return false;
        }
        // clean up
        while(j<p.length())
        {
            if (p.charAt(j)!='*')
            {
                return false;
            }
            j++;
        }
        return true;
    }
}
