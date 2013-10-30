public class Solution {
    public String strStr(String haystack, String needle) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // KMP algorithm
        if (needle==null || needle.length()<1)
        {
            return haystack;
        }
        else if (haystack==null || haystack.length()<needle.length())
        {
            return null;   
        }
        int []table=initialTable(needle);
        int i=0;
        int j=0;
        while(i+j<haystack.length())
        {
            if (haystack.charAt(i+j)==needle.charAt(j))
            {
                j++;
                if (j>=needle.length())
                {
                    return haystack.substring(i);
                }
            }
            else
            {
                i=i+j-table[j];
                if (table[j]>-1)
                {
                    j=table[j];
                }
                else
                {
                    j=0;
                }
            }
        }
        return null;
    }
    
    private int[] initialTable(String str)
    {
        int []result=new int[str.length()];
        if (str.length()<1)
        {
            return result;
        }
        result[0]=-1;
        if (str.length()<2)
        {
            return result;
        }
        result[1]=0;
        if (str.length()<3)
        {
            return result;
        }
        int pos=2;
        int cnd=0;
        while(pos<str.length())
        {
            // find a matched substring
            if (str.charAt(pos-1)==str.charAt(cnd))
            {
                cnd++;
                result[pos]=cnd;
                pos++;
            }
            // try to find a previous match
            else if (cnd>0)
            {
                cnd=result[cnd];
            }
            // no such match found, start a new one
            else
            {
                result[pos]=0;
                pos++;
            }
        }
        return result;
    }
}
