public class Solution {
    public ArrayList<String> letterCombinations(String digits) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        char[][] map={{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        ArrayList<String> result=new ArrayList<String>();
        result.add(new String(""));
        if (digits==null || digits.length()<1)
        {
            return result;
        }
        return letterCombinations(digits, 0, result, map);
    }
    
    private ArrayList<String> letterCombinations(String digits, int start, ArrayList<String> base, char[][] map)
    {
        if(start>=digits.length())
        {
            return base;
        }
        else
        {
            ArrayList<String> result=new ArrayList<String>();
            for(String str: base)
            {
                for(char x: map[digits.charAt(start)-'0'])
                {
                    result.add(new String(str+x));
                }
            }
            return letterCombinations(digits, start+1, result, map);
        }
    }
}
