package trial2;

import java.util.HashMap;

public class PalindromePartitioningII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioningII instance=new PalindromePartitioningII();
		System.out.println(instance.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
	}

	public int minCut(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // no obvious efficient solution, we try greedy search first
        if(s==null || s.length()<2)
        {
            return 0;
        }
        return minCut(s, 0, s.length()-1, new HashMap<Integer, Integer>(), new HashMap<Integer, Boolean>());
    }
    
	/**
     * @param s the input string
     * @param start the end of previous exploration
     * @param max the maximal number of cut still allowed to get a better solution
     * @param buffer_cut the buffer for the # cut required for s[start:end]
     * @param buffer_palindrome the buffer for defining palindrome
     * @output the min # of cuts required for s[start:end]
     */ 
    private int minCut(String s, int start, int max, HashMap<Integer, Integer> buffer_cut, HashMap<Integer, Boolean> buffer_palindrome)
    {
    	if (buffer_cut.containsKey(start))
        {
            return buffer_cut.get(start);
        }
        else if (start>=s.length())
        {
            return -1;
        }
    	if (max<=0)
    	{
    		return 0;
    	}
        else
        {
            // we the starting point as the number of remaining cut we have
            int result=Math.min(max-1, s.length()-start-1);
            for (int i=s.length()-1; i>=start; i--)
            {
                // a parlindrome find
                if (isPalindrome(s, start, i, buffer_palindrome))
                {
                    result=Math.min(result, minCut(s, i+1, result, buffer_cut, buffer_palindrome));
                }
            }
            result++;
            buffer_cut.put(start, result);
            return result;
        }
    }
    
    private boolean isPalindrome(String s, int start, int end, HashMap<Integer, Boolean> buffer)
    {
        if (buffer.containsKey(start*s.length()+end))
        {
            return buffer.get(start*s.length()+end);
        }
        else
        {
            for (int i=start; i<end-i+start; i++)
            {
                if (s.charAt(i)!=s.charAt(end-i+start))
                {
                    buffer.put(start*s.length()+end, false);
                    return false;
                }
            }
            buffer.put(start*s.length()+end, true);
            return true;
        }
    }
}
