public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we can use backtrace
        if (s==null || dict==null)
        {
            return new ArrayList<String>();
        }
        // we also conside dynamic programming
        // return wordBreak(s, 0, dict, new ArrayList<String>());
        return wordBreak(s, 0, dict, new HashMap<Integer, ArrayList<String>>());
    }
    
    /**
     * @param s the input string
     * @param start the location we start with
     * @param dict the dictionary
     * @param base the current string we have in the sentences
     */
    private ArrayList<String> wordBreak(String s, int start, Set<String> dict, ArrayList<String> base)
    {
        ArrayList<String> result=new ArrayList<String>();
        // base case
        if (start>=s.length())
        {
            StringBuffer str=new StringBuffer();
            for (int i=0; i<base.size(); i++)
            {
                if (i>0)
                {
                    str.append("");
                }
                str.append(" ");
            }
            result.add(str.toString());
        }
        else
        {
            // we try each possible break of words
            for (int i=start; i<s.length(); i++)
            {
                String str=s.substring(start, i+1);
                if (dict.contains(str))
                {
                    ArrayList<String> entry=new ArrayList<String>(base);
                    entry.add(str);
                    result.addAll(wordBreak(s, i, dict, entry));
                }
            }
        }
        return result;
    }
    
    /**
     * with buffer
     */
     private ArrayList<String> wordBreak(String s, int start, Set<String> dict, HashMap<Integer, ArrayList<String>> buffer)
    {
        if(buffer.containsKey(start))
        {
            return buffer.get(start);
        }
        else
        {
            ArrayList<String> result=new ArrayList<String>();
            // base case
            if (start>=s.length())
            {
                result.add(new String(""));
            }
            else
            {
                // we try each possible break of words
                for (int i=start; i<=s.length(); i++)
                {
                    String str=s.substring(start, i);
                    if (dict.contains(str))
                    {
                        ArrayList<String> base=wordBreak(s, i, dict, buffer);
                        for (String entry: base)
                        {
                        	if (entry.length()>0)
                        	{
                        		result.add(new String(str+" "+entry));
                        	}
                        	else
                        	{
                        		result.add(str);
                        	}
                        }
                    }
                }
            }
            buffer.put(start, result);
            return result;
        }
    }
}
