package Solution;

public class LongestCommonPrefix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []strs={"aa", "aa"};
		System.out.println("longest common prefix for [aa, aa]="+longestCommonPrefix(strs));
	}

	public static String longestCommonPrefix(String []strs)
	{
		// Start typing your Java solution below
        // DO NOT write main() function
        if (strs==null || strs.length<1)
        {
            return new String("");
        }
        if (strs[0]==null)
        {
            return new String("");
        }
        char []str=strs[0].toCharArray();
    	int j=str.length-1;
        int k;
		for (int i=1; i<strs.length; i++)
		{
            j=j>(strs[i].length()-1)?(strs[i].length()-1):j;
            for (k=j; k>=0; k--)
            {
                if (str[k]!=strs[i].charAt(k))
                {
                    j=k-1;
                }
            }
            if (j<0)
            {
                break;
            }
		}
        if (j>=0)
        {
		    return new String(str, 0, j+1);
        }
        {
            return new String("");
        }
	}
}
