package trial3;

import java.util.HashMap;
import java.util.Set;

public class WordBreak {
	/**
     * this can be viewed as a simpler case as the problem Word Break II
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()<1)
        {
            return true;
        }
        else if (dict==null || dict.size()<1)
        {
            return false;
        }
        else
        {
            return wordBreak(s, 0, dict, new HashMap<Integer, Boolean>());
        }
    }
    
    private boolean wordBreak(String s, int start, Set<String> dict, HashMap<Integer, Boolean> buffer)
    {
        if (buffer.containsKey(start))
        {
            return buffer.get(start);
        }
        else
        {
            boolean result=false;
            if (start>=s.length())
            {
                result=true;
            }
            else
            {
                for (int i=start; i<s.length(); i++)
                {
                    String sub=s.substring(start, i+1);
                    if (dict.contains(sub) && wordBreak(s, i+1, dict, buffer))
                    {
                        result=true;
                        break;
                    }
                }
            }
            buffer.put(start, result);
            return result;
        }
    }
}
