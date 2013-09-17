package Solution;

import java.util.HashMap;

public class InterleaveString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleaveString instance=new InterleaveString();
		System.out.println(instance.isInterleave("aa", "ab", "aaba"));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will try recursion first
        if (s1==null || s1.length()<1)
        {
            if (s2==null || s2.length()<1)
            {
                if (s3==null || s3.length()<1)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
            else
            {
                if (s3==null || s3.length()<1)
                {
                    return false;
                }
                else if (s3.length()!=s2.length())
                {
                    return false;
                }
                else
                {
                    for (int i=0; i<s3.length(); i++)
                    {
                        if (s2.charAt(i)!=s3.charAt(i))
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        else
        {
            if (s2==null || s2.length()<1)
            {
                if (s3==null || s3.length()<1)
                {
                    return false;
                }
                else if (s3.length()!=s1.length())
                {
                    return false;
                }
                else
                {
                    for (int i=0; i<s3.length(); i++)
                    {
                        if (s1.charAt(i)!=s3.charAt(i))
                        {
                            return false;
                        }
                    }
                    return true;
                }
            }
            else
            {
                if (s3==null || s3.length()<1)
                {
                    return false;
                }
                else if (s3.length()!=s1.length()+s2.length())
                {
                    return false;
                }
                else
                {
                	buffer=new HashMap<Integer, Boolean>();
                    return isInterleave(s1, 0, s2, 0, s3, 0);
                }
            }
        }
    }
	
	// for improvement we will use dynamic programming by a buffer
	private HashMap<Integer, Boolean> buffer;
    
    private boolean isInterleave(String s1, int i, String s2, int j, String s3, int k)
    {
    	if (buffer.containsKey(i*(s2.length()+1)+j))
    	{
    		return buffer.get(i*(s2.length()+1)+j);
    	}
    	boolean result;
        if (k==s3.length())
        {
            // we finish the match
            if (i==s1.length() && j==s2.length())
            {
                result=true;
            }
            // however some chars of s1 or s2 left out
            else
            {
                result=false;
            }
        }
        else if (i<s1.length() && s1.charAt(i)==s3.charAt(k) && isInterleave(s1, i+1, s2, j, s3, k+1))
        {
            result=true;
        }
        else if (j<s2.length() && s2.charAt(j)==s3.charAt(k) && isInterleave(s1, i, s2, j+1, s3, k+1))
        {
            result=true;
        }
        else
        {
            result=false;
        }
        buffer.put(i*(s2.length()+1)+j, result);
        return result;
    }
}
