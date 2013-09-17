package Solution;

public class StrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StrStr instance=new StrStr();
		System.out.println(instance.strStr("mississippi", "issip"));
	}

	public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// Start typing your Java solution below
        // DO NOT write main() function
        if (haystack==null)
        {
            return null;
        }
        else if(needle!=null && needle.length()>haystack.length())
        {
            return null;
        }
        else if (needle==null || needle.length()<1)
        {
            // need is empty, return anything we get
            return haystack;
        }
        // all the common case
        int i, j;
        i=0; j=0;
        int []pattern=findPattern(needle);
        while(i+j<haystack.length())
        {
            if (haystack.charAt(i+j)==needle.charAt(j))
            {
                // current match
                if (j>=needle.length()-1)
                {
                    return haystack.substring(i);
                }
                // try the next
                j++;
            }
            else
            {
                i=i+j-pattern[j];
                if (pattern[j]>-1)
                {
                    j=pattern[j];
                }
                else
                {
                    j=0;
                }
            }
        }
        return null;
    }
    
    private int[] findPattern(String str)
    {
        if (str==null || str.length()<1)
        {
            return null;
        }
        int []result=new int[str.length()];
        if (str.length()==1)
        {
            result[0]=-1;
            return result;
        }
        else if(str.length()==2)
        {
            result[0]=-1;
            result[1]=0;
            return result;
        }
        result[0]=-1;
        result[1]=0;
        int pos=2;
        int cnd=0;
        while(pos<str.length())
        {
            if (str.charAt(pos-1)==str.charAt(cnd))
            {
                result[pos++]=++cnd;
            }
            else if (cnd>0)
            {
                cnd=result[cnd];
            }
            else
            {
                result[pos++]=0;
            }
        }
        return result;
    }
}
