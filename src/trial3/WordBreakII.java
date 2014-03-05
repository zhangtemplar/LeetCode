package trial3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class WordBreakII {
	/**
     * we first try a exhaustive search, i.e., try to place the space in every possbile location
     * potential improvement: use a hashmap to store the result for each index
     */
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        if (s==null || s.length()<1 || dict==null || dict.size()<1)
        {
            return new ArrayList<String>();
        }
        // return wordBreak(s, 0, "", dict);
        return wordBreak(s, 0, dict, new HashMap<Integer, ArrayList<String>>());
    }
    
    /**
     * we use a buffer to store the possible word break for the substring s[key:].
     * the buffer is a hashmap, where value is the possible word breaks as array of strings
     * the output the set of word breaks for the substring s[start:]
     */
    private ArrayList<String> wordBreak(String s, int start, Set<String> dict, HashMap<Integer, ArrayList<String>> buffer)
    {
        if (buffer.containsKey(start))
        {
            return buffer.get(start);
        }
        else
        {
            ArrayList<String> result=new ArrayList<String>();
            if (start>=s.length())
            {
                result.add("");
            }
            else
            {
                for (int i=start; i<s.length(); i++)
                {
                    String sub=s.substring(start, i+1);
                    if (dict.contains(sub))
                    {
                        ArrayList<String> base=wordBreak(s, i+1, dict, buffer);
                        for (String str: base)
                        {
                            if (str.length()>0)
                            {
                                result.add(sub+" "+str);
                            }
                            else
                            {
                                result.add(sub);
                            }
                        }
                    }
                }
            }
            buffer.put(start, result);
            return result;
        }
    }
    
    /*
    private ArrayList<String> wordBreak(String s, int start, String base, Set<String> dict)
    {
        ArrayList<String> result=new ArrayList<String>();
        // we have finished
        if (start>=s.length())
        {
            result.add(base);
        }
        // not yet
        else
        {
            for (int i=start; i<s.length(); i++)
            {
                String sub=s.substring(start, i+1);
                if (dict.contains(sub))
                {
                    if (base.length()>0)
                    {
                        result.addAll(wordBreak(s, i+1, base+" "+sub, dict));
                    }
                    else
                    {
                        result.addAll(wordBreak(s, i+1, sub, dict));
                    }
                }
            }
        }
        return result;
    }
    */
}
