public class Solution {
    public int longestConsecutive(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we may use hashmap for this purpose
        // 1st hashmap (start) maps the start of the consecutive sequence to its length
        // 2nd hashmap (end) maps the end of the consecutive sequence to its length
        // we scan the array, for each element, we search for num-1 and num+1 in hashmap end and start accoringly
        // if it is found, we update the hashmap and check whether any entry of two hashmap can't merged
        // for complexity, each element of the array, will at most add one new entry to each hashmap
        // i.e., hashmap has space complexity O(n) and hashmap operation take O(1) time
        // when we looking for the maximal value for value set of hashmap, the time complexity will be O(n)
        if (num==null || num.length<1)
        {
            return 0;
        }
        HashMap<Integer, Integer> start=new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> end=new HashMap<Integer, Integer>();
        for (int i=0; i<num.length; i++)
        {
            boolean flag_start=false;
            boolean flag_end=false;
            // looking for the consecutive sequence
            if(start.containsKey(num[i]+1))
            {
                start.put(num[i], start.get(num[i]+1)+1);
                flag_start=true;
            }
            else
            {
                start.put(num[i], 1);
            }
            if(end.containsKey(num[i]-1))
            {
                end.put(num[i], end.get(num[i]-1)+1);
                flag_end=true;
            }
            else
            {
                end.put(num[i], 1);
            }
            // looking for a merge
            start.put(num[i]-end.get(num[i])+1, start.get(num[i])+end.get(num[i])-1);
            end.put(num[i]+start.get(num[i])-1, start.get(num[i])+end.get(num[i])-1);
        }
        // final step, we need to looking for the longest consecutive sequence
        int max=0;
        for (int x: start.values())
        {
            max=max>x?max:x;
        }
        for (int x: end.values())
        {
            max=max>x?max:x;
        }
        return max;
    }
}
