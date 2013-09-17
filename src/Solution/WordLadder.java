package Solution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String start="a";
		String end="c";
		HashSet<String> dict=new HashSet<String>();
		dict.add("a");
		dict.add("b");
		dict.add("c");
		WordLadder instance=new WordLadder();
		System.out.println(instance.ladderLength(start, end, dict));
	}

	public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // it is a shortest path problem
        // we can formulate the problem as follows: we build a graph
        // where node is the string, and two nodes are conneced if and only if
        // the corresponding two strings are different in only one letter
        // the algorithm starts at start and ends at end
        // we will need a hashset to mark the visited string
        // and a queue to store the to be visited string
        HashMap<String, Integer> visited=new HashMap<String, Integer>();
        LinkedList<String> queue=new LinkedList<String>();
        if (start==null || end==null || start.length()!=end.length())
        {
            return 0;
        }
        // we also need to store the distance from the start
        visited.put(start, 1);
        queue.add(start);
        while(!queue.isEmpty())
        {
            String s=queue.remove();
            char[] chars=s.toCharArray();
            for (int i=0; i<s.length(); i++)
            {
                char old=chars[i];
                for (char c='a'; c<='z'; c++)
                {
                    chars[i]=c;
                    String s2=new String(chars);
                    if (s2.equals(end))
                    {
                        // we found it
                        return visited.get(s)+1;
                    }
                    if (dict.contains(s2) && !visited.containsKey(s2))
                    {
                        // add it to the queue
                        visited.put(s2, visited.get(s)+1);
                        queue.add(s2);
                    }
                }
                chars[i]=old;
            }
        }
        return 0;
    }
}
