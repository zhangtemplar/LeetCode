package Solution;

public class LongestSubstringNonrepeat {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("The length of the longest substring without repeating characters of abcabcbb is "+lengthOfLongestSubstring("abcabcbb"));
		System.out.println("The length of the longest substring without repeating characters of bbbbb is "+lengthOfLongestSubstring("bbbbb"));
		System.out.println("The length of the longest substring without repeating characters of hchzvfrkmlnozjk is "+lengthOfLongestSubstring("hchzvfrkmlnozjk"));
	}

    public static int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // the idea is simple, we define a window which scans in the string
        // The windows starts from maximal to the minimal, whenever we find a valid
        // window we terminate
        int start, size;
        start=0;
        size=s.length();
        int []alphabet=new int[256];
        for (int i=0; i<s.length(); i++)
        {
            alphabet[s.charAt(i)]++;
        }
        if (isValid(alphabet))
        {
            return size;
        }
        // start the scaning
        size--;
        for (; size>0; size--)
        {
            // we use zigzag order
            if (size%2==0)
            {
                // start from the left
                alphabet[s.charAt(size)]--;
                if (isValid(alphabet))
                {
                   return size;
                }
                for (start=1; start<=s.length()-size; start++)
                {
                    alphabet[s.charAt(start-1)]--;
                    alphabet[s.charAt(start+size-1)]++;
                    if (isValid(alphabet))
                    {
                       return size;
                    }
                }
            }
            else
            {
                // start from the right
                alphabet[s.charAt(s.length()-1-size)]--;
                if (isValid(alphabet))
                {
                   return size;
                }
                for (start=s.length()-2; start>size-2; start--)
                {
                    alphabet[s.charAt(start+1)]--;
                    alphabet[s.charAt(start-size+1)]++;
                    if (isValid(alphabet))
                    {
                       return size;
                    }
                }
            }
        }
        return size;
    }
    
    private static boolean isValid(int []s)
    {
        for (int i='a'; i<='z'; i++)
        {
            if (s[i]>1)
            {
                return false;
            }
        }
        return true;
    }
}
