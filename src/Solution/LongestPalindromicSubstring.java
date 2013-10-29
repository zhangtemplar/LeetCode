public class Solution {
    public String longestPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null || s.length()<1)
        {
            return new String("");
        }
        int max_l=1;
        int max_i=0;
        int max_j=0;
        for (int i=0; i<s.length(); i++)
        {
            // we are only interested in parlindrome which is longer than longest known one
            for (int j=Math.min(i+999, s.length()-1); j>=i+max_l; j--)
            {
                if (Palindrome(s, i, j))
                {
                    if (max_l<(j-i+1))
                    {
                        max_l=j-i+1;
                        max_i=i;
                        max_j=j;
                        if (max_l==1000)
                        {
                            return s.substring(max_i, max_j+1);
                        }
                    }
                }
            }
        }
        return s.substring(max_i, max_j+1);
    }
    
    private boolean Palindrome(String s, int i, int j)
    {
        for (int p=i; p<j-p+i; p++)
        {
            if (s.charAt(p)!=s.charAt(j-p+i))
            {
                return false;
            }
        }
        return true;
    }
}
