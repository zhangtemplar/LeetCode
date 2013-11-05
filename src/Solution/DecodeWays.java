public class Solution {
    public int numDecodings(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we use dynamic programming
        if (s==null || s.length()<1)
        {
            return 0;
        }
        return numDecodings(s, 0, new HashMap<Integer, Integer>());
    }
    
    private int numDecodings(String s, int start, HashMap<Integer, Integer> buffer)
    {
        if(buffer.containsKey(start))
        {
            return buffer.get(start);
        }
        else if(start>=s.length())
        {
            return 1;
        }
        else
        {
            int result=0;
            if (s.charAt(start)=='0')
            {
                // illegal case
                result=0;
            }
            else if (start<s.length()-1 && ((s.charAt(start)-'0')*10+(s.charAt(start+1)-'0'))<=26)
            {
                // we can either have a double or single
                result=numDecodings(s, start+1, buffer)+numDecodings(s, start+2, buffer);
            }
            else
            {
                result=numDecodings(s, start+1, buffer);
            }
            buffer.put(start, result);
            return result;
        }
    }
}
