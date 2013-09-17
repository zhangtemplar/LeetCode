package Solution;

import java.util.HashMap;

public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
    	// the hashmap map map the start of the sequence to its length
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        for (int i : num) {
            if (map.containsKey(i)) 
            {
                continue;
            }
            map.put(i, 1);
            // merge i to the end
            if (map.containsKey(i - 1)) 
            {
                max = Math.max(max, merge(map, i-1, i));
            }
            // merge i to the start
            if (map.containsKey(i + 1)) 
            {
                max = Math.max(max, merge(map, i, i+1));
            }
        }
        return max;
    }
    
    private int merge(HashMap<Integer, Integer> map, int left, int right) 
    {
        int upper = right + map.get(right) - 1;
        int lower = left - map.get(left) + 1;
        int len = upper - lower + 1;
        map.put(upper, len);
        map.put(lower, len);
        return len;
    }
}
