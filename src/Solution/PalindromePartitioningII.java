package Solution;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * we shall use the similar the algorithm as previous, instead, we 
 * return the # cuts instead of the detailed cuts.
 * @author qzhang53
 *
 */
public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII instance=new PalindromePartitioningII();
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(instance.minCut(s));
	}

	public int minCut(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.length()<1)
        {
            return 0;
        }
        is_palindrome=new HashMap<SubString, Boolean>();
        buffer_partition=new HashMap<SubString, Integer>();
        return minCut(s, 0);
    }
    
    // this is the buffer for quickly determining whether is a palindrome of not
    private HashMap<SubString, Boolean> is_palindrome;
    
    // this buffer stores the minimum # cut for the substring
    private HashMap<SubString, Integer> buffer_partition;
    
    private int minCut(String s, int start) 
    {
        if (buffer_partition.containsKey(new SubString(start, s.length()-1, s.length())))
        {
            return buffer_partition.get(new SubString(start, s.length()-1, s.length()));
        }
        int result=Integer.MAX_VALUE;
        if (start==s.length()-1)
        {
            return 0;
        }
        else if(start>=s.length())
    	{
        	return -1;
    	}
        for (int i=start; i<s.length(); i++)
        {
            if (isPalindrome(s, start, i))
            {
                int base=minCut(s, i+1);
                if (result>base)
                {
                	result=base;
                }
            }
        }
        result++;
        buffer_partition.put(new SubString(start, s.length()-1, s.length()), result);
        return result;
    }
    
    private boolean isPalindrome(String s, int start, int end)
    {
        if (is_palindrome.containsKey(new SubString(start, end, s.length())))
        {
            return is_palindrome.get(new SubString(start, end, s.length()));
        }
        if (start>=end)
        {
            return true;
        }
        int i=start;
        int j=end;
        for(; i<j; i++, j--)
        {
            if (s.charAt(i)!=s.charAt(j))
            {
                is_palindrome.put(new SubString(start, end, s.length()), false);
                return false;
            }
        }
        is_palindrome.put(new SubString(start, end, s.length()), true);
        return true;
    }
}
