public class Solution {
    public int longestConsecutive(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we have two hashmap to stores the start/end (as key) and the length (as value) of the sequence
        if (num==null || num.length<1)
        {
            return 0;
        }
        HashSet<Integer> visited=new HashSet<Integer>();
        HashMap<Integer, Integer> start=new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> end=new HashMap<Integer, Integer>();
        for (int i=0; i<num.length; i++)
        {
            int key=num[i];
            if (visited.contains(key))
            {
            	continue;
            }
            visited.add(key);
            if (!start.containsKey(key))
            {
                start.put(key, 1);
            }
            if (!end.containsKey(key))
            {
                end.put(key, 1);
            }
            
            // search to the right, sequence starts with key+1
            if(start.containsKey(key+1))
            {
                start.put(key, start.get(key+1)+1);
                start.remove(key+1);  
            }
            
            // search to the left, i.e., sequence ends with key-1
            if(end.containsKey(key-1))
            {
                end.put(key, end.get(key-1)+1);
                end.remove(key-1);
            }
            
            // check whether two entry can be merged
            if (start.get(key)>1 || end.get(key)>1)
            {
                int value=start.get(key);
                if (key!=key-end.get(key)+1)
                {
                    start.put(key-end.get(key)+1, start.get(key)+end.get(key)-1);
                    start.remove(key);
                }
                if (key!=key+value-1)
                {
                    end.put(key+value-1, value+end.get(key)-1);
                    end.remove(key);
                }
            }
        }
        int max=1;
        for (int x: start.values())
        {
            if (x>max)
            {
                max=x;
            }
        }
        return max;
    }
}
