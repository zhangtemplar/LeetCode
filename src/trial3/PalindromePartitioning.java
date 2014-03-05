package trial3;

import java.util.ArrayList;
import java.util.HashMap;

public class PalindromePartitioning {
	public ArrayList<ArrayList<String>> partition(String s) {
        return partition(s, 0, new HashMap<int[], Boolean>(), new HashMap<Integer, ArrayList<ArrayList<String>>>());
    }
    
    /**
     * the core algorithm
     * we use palindrome to cache all the palindrome detection result
     * buffer to cache all the set of partition of the substring we have explored
     */
    private ArrayList<ArrayList<String>> partition(String s, int start, HashMap<int[], Boolean> palindrome, HashMap<Integer, ArrayList<ArrayList<String>>> buffer)
    {
        if (buffer.containsKey(start))
        {
            return buffer.get(start);
        }
        else
        {
            ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
            if (start>=s.length())
            {
                ArrayList<String> entry=new ArrayList<String>();
                result.add(entry);
            }
            else
            {
                for (int i=start; i<s.length(); i++)
                {
                    if (isPalindrome(s, start, i, palindrome))
                    {
                        ArrayList<ArrayList<String>> base=partition(s, i+1, palindrome, buffer);
                        String str=s.substring(start, i+1);
                        for (ArrayList<String> entry: base)
                        {
                            ArrayList<String> element=new ArrayList<String>();
                            element.add(str);
                            element.addAll(entry);
                            result.add(element);
                        }
                    }
                }
            }
            buffer.put(start, result);
            return result;
        }
    }
    
    /**
     * check whether a substring is palindrome or not
     */
    private boolean isPalindrome(String s, int start, int end, HashMap<int[], Boolean> palindrome)
    {
        int []key={start, end};
        if (palindrome.containsKey(key))
        {
            return palindrome.get(key);
        }
        else
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
            palindrome.put(key, result);
            return result;
        }
    }
}
