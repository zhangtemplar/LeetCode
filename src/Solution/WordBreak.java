public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // back trace
        if (s==null || s.length()<1)
        {
            return true;
        }
        if (dict.isEmpty())
        {
            return false;
        }
        int min=s.length();
        int max=0;
        for(String str: dict)
        {
            if (min>str.length())
            {
                min=str.length();
            }
            if (max<str.length())
            {
                max=str.length();
            }
        }
        HashMap<Integer, Boolean> buffer=new HashMap<Integer, Boolean>();
        return wordBreak(s, 0, dict, min, max, buffer);
    }
    
    private boolean wordBreak(String s, int start, Set<String> dict, int min, int max, HashMap<Integer, Boolean> buffer)
    {
        if (buffer.containsKey(start))
        {
            return buffer.get(start);
        }
        if (start>=s.length())
        {
            return true;
        }
        else
        {
            for (int i=start+min; i<=start+max && i<=s.length(); i++)
            {
                if (dict.contains(s.substring(start, i)) && wordBreak(s, i, dict, min, max, buffer))
                {
                    buffer.put(start, true);
                    return true;
                }
            }
            buffer.put(start, false);
            return false;
        }
    }
}
