public class Solution {
    public boolean isPalindrome(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null || s.length()<1)
        {
            return true;
        }
        String str=s.toLowerCase();
        int i=0;
        int j=str.length()-1;
        while(i<j)
        {
            if (isalphanumeric(str.charAt(i))==false)
            {
                i++;
            }
            else if (isalphanumeric(str.charAt(j))==false)
            {
                j--;
            }
            else
            {
                if (str.charAt(i)!=str.charAt(j))
                {
                    return false;
                }
                else
                {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
    
    private boolean isalphanumeric(char c)
    {
        return (c>='0' && c<='9') || (c>='a' && c<='z');
    }
}
