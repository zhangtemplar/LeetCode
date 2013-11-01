public class Solution {
    public int longestValidParentheses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (s==null || s.length()<2)
        {
            return 0;
        }
        // we first use ) to seperate the string into substrings, where each ) is matched
        int balance=0;
        int max=0;
        int length=0;
        int last=0;
        for (int i=0; i<s.length(); i++)
        {
            if (s.charAt(i)=='(')
            {
                balance++;
                length++;
            }
            else if(balance>0)
            {
                balance--;
                length++;
            }
            else
            {
                if (max<length)
                {
                    max=length;
                }
                last=i+1;
                length=0;
            }
        }
        // we have found some extra (s, we need to find them out
        if (balance!=0)
        {
            length=longestValidParentheses(s, last, s.length()-1);
            if (max<length)
            {
                max=length;
            }
        }
        if (max<length)
        {
            max=length;
        }
        return max;
    }
    
    private int longestValidParentheses(String s, int start, int end)
    {
        int balance=0;
        int max=0;
        int length=0;
        for (int i=end; i>=start; i--)
        {
            if (s.charAt(i)==')')
            {
                balance++;
                length++;
            }
            else if(balance>0)
            {
                balance--;
                length++;
            }
            else
            {
                if (max<length)
                {
                    max=length;
                }
                length=0;
            }
        }
        if (max<length)
        {
            max=length;
        }
        return max;
    }
}
