public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we use dynamic programming
        // we start with substring of length 1, record as the current maximal
        // we add the right if no duplicates found
        // otherwise we remove the left, until the duplicates is moved
        // we update the maximal when necessary
        if (s==null || s.length()<1)
        {
            return 0;
        }
        // we will use a hashMap to store the found element
        HashMap<Character, Integer> table=new HashMap<Character, Integer>();
        int left=0;
        int right=0;
        int max=1;
        table.put(s.charAt(left), 1);
        while(left<=right && right<s.length()-1)
        {
            // ok, no duplicates, we can move on
            right++;
            if (!table.containsKey(s.charAt(right)) || table.get(s.charAt(right))<1)
            {
                if (max<right-left+1)
                {
                    max=right-left+1;
                }
                table.put(s.charAt(right), 1);
            }
            // we need to shrink the left to remove the duplicate
            else
            {
                // add the right anyway
                table.put(s.charAt(right), table.get(s.charAt(right))+1);
                // remove the duplicate due to right by shrinking on the left
                while(table.get(s.charAt(right))>1 && left<right)
                {
                    if (table.get(s.charAt(left))>0)
                    {
                        table.put(s.charAt(left), table.get(s.charAt(left))-1);
                    }
                    left++;
                }
            }
        }
        return max;
    }
}
