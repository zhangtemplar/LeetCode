public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // anagrams are words which have the same counting of character
        // we group the string according to their anagrams property
        // for implementation, we use hashmap to store the groups
        // finally we return the groups which are larger than 1
        if (strs==null || strs.length<1)
        {
            return new ArrayList<String>();
        }
        // the map of group index to the counting table.
        HashMap<ArrayList<Integer>, ArrayList<String>> map=new HashMap<ArrayList<Integer>, ArrayList<String>>();
        for (String str: strs)
        {
            ArrayList<Integer> table=countLetter(str);
            if (map.containsKey(table))
            {
                map.get(table).add(str);
            }
            else
            {
                // we found a new group
                ArrayList<String> entry=new ArrayList<String>();
                entry.add(str);
                map.put(table, entry);
            }
        }
        // finally return all the group whose size is larger than 1
        ArrayList<String> result=new ArrayList<String>();
        for (ArrayList<String> entry: map.values())
        {
            if (entry.size()>1)
            {
                result.addAll(entry);
            }
        }
        return result;
    }
    
    private boolean isAnagram(ArrayList<Integer> x, ArrayList<Integer> y)
    {
        for (int i=0; i<x.size(); i++)
        {
            if (!x.get(i).equals(y.get(i)))
            {
                return false;
            }
        }
        return true;
    }
    
    private ArrayList<Integer> countLetter(String s)
    {
        int []result=new int[26];
        for(int i=0; i<s.length(); i++)
        {
            result[s.charAt(i)-'a']++;
        }
        ArrayList<Integer> table=new ArrayList<Integer>(26);
        for (int i=0; i<result.length; i++)
        {
            table.add(i, result[i]);
        }
        return table;
    }
}
