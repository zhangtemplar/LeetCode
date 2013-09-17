package Solution;

import java.util.HashMap;

public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays instance=new DecodeWays();
		System.out.println(instance.numDecodings("1787897759966261825913315262377298132516969578441236833255596967132573482281598412163216914566534565"));
	}

	public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we may use recursion
        if (s==null || s.length()<1)
        {
            return 0;
        }
        set=new HashMap<Integer, Integer>();
        return numDecodings(s, 0);
    }

	private HashMap<Integer, Integer> set;
	
    private int numDecodings(String s, int start)
    {
    	int result;
    	if (start>s.length())
        {
            return 0;
        }
    	else if (start==s.length())
    	{
    		return 1;
    	}
        else if (s.charAt(start)=='0')
        {
            return 0;
        }
        else if (start==s.length()-1)
        {
        	return 1;
        }
        else if (set.containsKey(start))
        {
        	return set.get(start);
        }
        else if (s.charAt(start)>'2')
        {
            return numDecodings(s, start+1);
        }
        else if (s.charAt(start)=='2')
        {
            // we need to decide
            if (s.charAt(start+1)>'6')
            {
            	result=numDecodings(s, start+1);
            }
            else if (s.charAt(start+1)=='0')
            {
            	// 20
            	result=numDecodings(s, start+2);
            }
            else
            {
            	result=numDecodings(s, start+1)+numDecodings(s, start+2);
            }
        }
        else
        {
        	// the end of string
            if (s.charAt(start+1)=='0')
            {
            	// 10
            	result=numDecodings(s, start+2);
            }
            else
            {
            	// 11, 12, ...
            	result=numDecodings(s, start+1)+numDecodings(s, start+2);
            }
        }
    	set.put(start, result);
    	return result;
    }
}
