public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        // to improve the speed, we use hashset to store the parlindrome found in the string
        if (s==null || s.length()<1)
        {
            ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
            result.add(new ArrayList<String>());
            return result;
        }
        buffer=new HashMap<String, Boolean>();
        return partition(s, 0, new ArrayList<String>());
    }
    
    private HashMap<String, Boolean> buffer;
    
    /**
     * @param end is the index to be processed
     * @param base is the result found from the previous part
     */ 
    private ArrayList<ArrayList<String>> partition(String s, int end, ArrayList<String> base)
    {
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        if (end>=s.length())
        {
            result.add(base);
            return result;
        }
        else
        {
            for (int i=end; i<s.length(); i++)
            {
                // check whether s[end:i] is a palindrome or not
                if (isPalindrome(s, end, i))
                {
                    ArrayList<String> element=new ArrayList<String>(base);
                    element.add(s.substring(end, i+1));
                    result.addAll(partition(s, i+1, element));
                }
            }
            return result;
        }
    }
    
    /**
     * determine whether s[start:end] is a palindrome
     * we also use a hashmap to look up previous result quickly
     */ 
    private boolean isPalindrome(String s, int start, int end)
    {
        if (start==end)
        {
            return true;
        }
        else if(start<end)
        {
            String str=s.substring(start, end+1);
            if (buffer.containsKey(str))
            {
                return buffer.get(str);
            }
            else
            {
                boolean flag=true;
                for (int i=0; i<str.length()-i-1; i++)
                {
                    if (str.charAt(i)!=str.charAt(str.length()-i-1))
                    {
                        flag=false;
                        break;
                    }
                }
                buffer.put(str, flag);
                return flag;
            }
        }
        return false;
    }
}
