package trial3;

import java.util.Arrays;

public class PalindromePartitioningII {
	public static void main(String[] args)
	{
		System.out.println(new PalindromePartitioningII().minCut2("cdd"));
		// System.out.println(new PalindromePartitioningII().minCut("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"));
	}
	
	/**
	 * we still use dynamic programming
	 * cut(i) is the mincut for substring s[0:i]
	 * cut(i)=1, if s[0,i] is palindrome
	 * cut(i)=min{cut(j) if s[j:i] is palindrome}
	 */
	public int minCut2(String s)
	{
		long[] buffer=new long[s.length()];
		boolean[][] palindrome=isPalindrome(s);
		Arrays.fill(buffer, s.length()-1);
		buffer[0]=0;
		for (int i=1; i<s.length(); i++)
		{
			if (palindrome[0][i])
			{
				buffer[i]=0;
				continue;
			}
			for (int j=1; j<=i; j++)
			{
				if (palindrome[j][i] && buffer[i]>buffer[j-1]+1)
				{
					buffer[i]=buffer[j-1]+1;
				}
			}
		}
		return (int)buffer[s.length()-1];
	}
	
	private boolean[][] isPalindrome(String s)
	{
		boolean [][]result=new boolean[s.length()][s.length()];
		
		for (int i=0; i<s.length(); i++)
		{
			for (int j=0; i+j<s.length(); j++)
			{
				if (i==0)
				{
					result[j][i+j]=true;
				}
				else if (i==1 && s.charAt(j)==s.charAt(i+j))
				{
					result[j][i+j]=true;
				}
				else
				{
					result[j][i+j]=result[j+1][i+j-1] & s.charAt(j)==s.charAt(i+j);
				}
			}
		}
		return result;
	}
	
	/**
     * this could be a dynamic programming problem
     * cut(i,j) is the mincut for substring s[i:j]
     * then cut(i,j)=1+min_{i<=k<j}{cut(i,k)+cut(k+1,j)}
     */
    public int minCut(String s) {
        long[][] buffer=new long[s.length()][s.length()];
        for (int i=0; i<s.length(); i++)
        {
            Arrays.fill(buffer[i], Integer.MAX_VALUE);
            // for a single letter, it is always palindrome
            buffer[i][i]=0;
        }
        
        // for each length of substring
        for (int j=1; j<s.length(); j++)
        {
            // for each starting point of substring
            for (int i=0; i+j<s.length(); i++)
            {
                // check if its palindrome, if yes, no need to proceed
                if (isPalindrome(s, i, i+j))
                {
                    buffer[i][i+j]=0;
                    continue;
                }
                // otherwise, apply the equation
                for (int k=i; k<i+j; k++)
                {
                    // this 1 is due to the cut at k
                    long tmp=1+buffer[i][k]+buffer[k+1][i+j];
                    if (tmp<buffer[i][i+j])
                    {
                        buffer[i][i+j]=tmp;
                    }
                }
            }
        }
        return (int)buffer[0][s.length()-1];
    }
    
    /**
     * check whether a substring is palindrome or not
     */
    private boolean isPalindrome(String s, int start, int end)
    {
        boolean result=true;
        for (int i=0; start+i<=end-i; i++)
        {
            if (s.charAt(start+i)!=s.charAt(end-i))
            {
                result=false;
                break;
            }
        }
        return result;
    }
}
