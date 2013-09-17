package Solution;

import java.util.ArrayList;

public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses instance=new RestoreIPAddresses();
		System.out.println(instance.restoreIpAddresses("010010"));
	}

	public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion, however, parse the string in triple
        ArrayList<String> result=new ArrayList<String>();
        // obviously illegal case
        if (s==null || s.length()<4 || s.length()>12)
        {
            return result;
        }
        int[] cuts=new int[3];
        cuts[0]=1;
        result.addAll(restoreIpAddresses(s, cuts, 1));
        cuts[0]=2;
        result.addAll(restoreIpAddresses(s, cuts, 1));
        cuts[0]=3;
        result.addAll(restoreIpAddresses(s, cuts, 1));
        return result;
    }
    
    // start indicates the string we are parsing
    // cuts for the current cutting position (the start of each segment)
    // n indicates the number of segements already obtained
    private ArrayList<String> restoreIpAddresses(String s, int[] cuts, int n)
    {
        ArrayList<String> result=new ArrayList<String>();
        // we first check the string are good so far
        if (cuts[n-1]>=s.length())
        {
            return result;
        }
        // first we will check the previous section is valid or not
        long val;
        if (n==1)
        {
            if (!validSegment(s, 0, cuts[0]))
            {
                return result;
            }
            val=Long.parseLong(s.substring(0, cuts[0]));
        }
        else
        {
            if (!validSegment(s, cuts[n-2], cuts[n-1]))
            {
                return result;
            }
        	val=Long.parseLong(s.substring(cuts[n-2], cuts[n-1]));
        }
        // this is not a valid segment
        if (val>255 || val<0)
        {
            return result;
        }
        // everything is good so far
        if (n==3)
        {
            // we have finished the cutting, but need to check the last segment
        	if (!validSegment(s, cuts[n-1], s.length()))
            {
                return result;
            }
            val=Integer.parseInt(s.substring(cuts[n-1], s.length()));
            if (val>255 || val<0)
            {
                return result;
            }
            else
            {
                result.add(string2IP(s, cuts));
                return result;
            }
        }
        else
        {
            // just found the possible cutting location
            for (int i=cuts[n-1]+1; i<s.length(); i++)
            {
                cuts[n]=i;
                result.addAll(restoreIpAddresses(s, cuts, n+1));
                cuts[n]=0;
            }
            return result;
        }
    }
    
    private boolean validSegment(String s, int start, int end)
    {
    	if (start==end-1)
    	{
    		return true;
    	}
    	else
    	{
    		return s.charAt(start)!='0';
    	}
    }
    
    private String string2IP(String s, int[]cuts)
    {
        StringBuffer result=new StringBuffer();
        result.append(s.substring(0, cuts[0]));
        result.append('.');
        result.append(s.substring(cuts[0], cuts[1]));
        result.append('.');
        result.append(s.substring(cuts[1], cuts[2]));
        result.append('.');
        result.append(s.substring(cuts[2], s.length()));
        return result.toString();
    }
}
