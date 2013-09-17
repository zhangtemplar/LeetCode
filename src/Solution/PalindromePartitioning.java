package Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class PalindromePartitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalindromePartitioning instance=new PalindromePartitioning();
		String s="a";
		System.out.println(instance.partition(s));
	}

	public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.length()<1)
        {
            return new ArrayList<ArrayList<String>>();
        }
        is_palindrome=new HashMap<SubString, Boolean>();
        buffer_partition=new HashMap<SubString, ArrayList<ArrayList<String>>>();
        return partition(s, 0);
    }
    
    // this is the buffer for quickly determining whether is a palindrome of not
    private HashMap<SubString, Boolean> is_palindrome;
    
    // this buffer stores the possible partition for the substring
    private HashMap<SubString, ArrayList<ArrayList<String>>> buffer_partition;
    
    private ArrayList<ArrayList<String>> partition(String s, int start) 
    {
        if (buffer_partition.containsKey(new SubString(start, s.length()-1, s.length())))
        {
            return buffer_partition.get(new SubString(start, s.length()-1, s.length()));
        }
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        if (start>=s.length())
        {
            return result;
        }
        for (int i=start; i<s.length(); i++)
        {
            if (isPalindrome(s, start, i))
            {
                ArrayList<ArrayList<String>> base=partition(s, i+1);
                if (base.isEmpty())
                {
                	ArrayList<String> entry=new ArrayList<String>();
                    entry.add(0, s.substring(start, i+1));
                    result.add(entry);
                }
                for (ArrayList<String> path: base)
                {
                    ArrayList<String> entry=new ArrayList<String>(path);
                    entry.add(0, s.substring(start, i+1));
                    result.add(entry);
                }
            }
        }
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

class SubString
{
    int start, end, len;
    public SubString(int s, int e, int l)
    {
        start=s;
        end=e;
        len=l;
    }
    
    public int hashCode()
    {
        return start+end*len;
    }
    
    public boolean equals(Object obj)
    {
        if (obj instanceof SubString)
        {
            SubString tmp=(SubString) obj;
            return tmp.start==start && tmp.end==end && tmp.len==len;
        }
        return false;
    }
}
