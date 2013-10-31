public class Solution {
    public boolean isScramble(String s1, String s2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s1==null || s2==null || s1.length()!=s2.length())
        {
            return false;
        }
        return isScramble(s1, 0, s1.length()-1, s2, 0, s2.length()-1);
    }
    
    /**
     * this function checks whether s1[start1:end1] is a scramble of s2[start2:end2]
     */
    private boolean isScramble(String s1, int start1, int end1, String s2, int start2, int end2)
    {
        // base case
        if (start1>end1)
        {
            return true;
        }
        else if (start1==end1)
        {
            return s1.charAt(start1)==s2.charAt(start2);
        }
        else
        {
            // check the letter table first;
            if (!checkCount(s1, start1, end1, s2, start2, end2))
            {
                return false;
            }
            // the tree is not necessary balanced
            // so we need to try every possible partition
            for (int i=start1; i<end1; i++)
            {
                // ordianry case
                if (isScramble(s1, start1, i, s2, start2, start2+i-start1) && isScramble(s1, i+1, end1, s2, end2-end1+i+1, end2))
                {
                    return true;
                }
                // scramble case
                else if(isScramble(s1, start1, i, s2, end2-i+start1, end2) && isScramble(s1, i+1, end1, s2, start2, start2+end1-i-1))
                {
                    return true;
                }
            }
            return false;
        }
    }
    
    private boolean checkCount(String s1, int start1, int end1, String s2, int start2, int end2)
    {
        int[] table=new int[256];
        for (int i=start1; i<=end1; i++)
        {
            table[s1.charAt(i)]++;
            table[s2.charAt(start2+i-start1)]--;
        }
        for (int i=0; i<table.length; i++)
        {
            if (table[i]!=0)
            {
                return false;
            }
        }
        return true;
    }
}
