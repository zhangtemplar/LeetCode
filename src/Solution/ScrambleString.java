package Solution;

import java.util.HashMap;

public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString instance=new ScrambleString();
		System.out.println(instance.isScramble("abab", "bbaa"));
	}

	public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can use recursion, at each node, the counting of chars in the substring should be 
        // the same or just a swap
		// it is too slow, we will use dynamic programming
        if (s1==null || s1.length()<1)
        {
            if (s2==null || s2.length()<1)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else if (s1.length()!=s2.length())
        {
            return false;
        }
        else
        {
            return isScramble(s1, 0, s1.length()-1, s2, 0, s2.length()-1);
        }
    }
	
    private boolean isScramble(String s1, int start1, int end1, String s2, int start2, int end2)
    {
        if ((start1-end1)!=(start2-end2))
        {
            // first make sure the two substring are equal long
            return false;
        }
        // the base case--leaf node
        if (start1==end1)
        {
            return s1.charAt(start1)==s2.charAt(start2);
        }
        // no leaf node, we split it into halves, left can be smaller than right by 1
        else
        {
            // we will use recursive search
        	// first check the counting of current node
        	int []count=new int[256];
        	for (int i=start1; i<=end1; i++)
        	{
        		count[s1.charAt(i)]++;
        		int j=start2-start1+i;
        		count[s2.charAt(j)]--;
        	}
        	for (int i=0; i<256; i++)
        	{
        		if (count[i]!=0)
        		{
        			return false;
        		}
        	}
        	// we find a partition location i for s1
        	// then the partition location for s2 should be also i or n-i
        	for (int i=start1; i<end1; i++)
        	{
        		// try j=i first
        		if (isScramble(s1, start1, i, s2, start2, start2+i-start1) && isScramble(s1, i+1, end1, s2, start2+i+1-start1, end2))
        		{
        			return true;
        		}
        		// then j=n-i
        		else if(isScramble(s1, start1, i, s2, end2+start1-i, end2) && isScramble(s1, i+1, end1, s2, start2, start2+end1-i-1))
        		{
        			return true;
        		}
        	}
        	return false;
        }
    }
}
