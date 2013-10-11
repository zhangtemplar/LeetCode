public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (strs==null || strs.length<1)
        {
            return new String("");
        }
        int i=0;
        for (i=0; i<strs[0].length(); i++)
        {
            char c=strs[0].charAt(i);
            for(String str: strs)
            {
                if (i>=str.length() || str.charAt(i)!=c)
                {
                    if (i>0)
                    {
                        return strs[0].substring(0, i);
                    }
                    else
                    {
                        return new String("");
                    }
                }
            }
        }
        if (i>0)
        {
            return strs[0].substring(0, i);
        }
        else
        {
            return new String("");
        }
    }
}
