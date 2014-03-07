package trial3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * this problem can be solved as a shorest path in graph via bread first search
     */
    public int ladderLength(String start, String end, HashSet<String> dict) {
        if (start==null || end==null || dict==null || dict.size()<1)
        {
            return 0;
        }
        else if (start.equals(end))
        {
            return 2;
        }
        else if (!dict.contains(start) || !dict.contains(end))
        {
            return 0;
        }
        LinkedList<String> queue=new LinkedList<String>();
        // we store the visted string and also the distance from the start (1)
        HashMap<String, Integer> visited=new HashMap<String, Integer>();
        queue.add(start);
        visited.put(start, 1);
        while(!queue.isEmpty())
        {
            String str=queue.remove();
            if (end.equals(str))
            {
                return visited.get(str);
            }
            // check the neighbor
            char []new_str=str.toCharArray();
            for (int i=0; i<str.length(); i++)
            {
                for (char c='a'; c<='z'; c++)
                {
                    // the str itself
                    if (c==str.charAt(i))
                    {
                        continue;
                    }
                    new_str[i]=c;
                    String neighbor=new String(new_str);
                    // check whehter this string is valid and unvisited before
                    if (dict.contains(neighbor) && !visited.containsKey(neighbor))
                    {
                        // add this string to the list and visited, compute its distance
                        visited.put(neighbor, visited.get(str)+1);
                        queue.add(neighbor);
                    }
                }
                new_str[i]=str.charAt(i);
            }
        }
        return 0;
    }
}
