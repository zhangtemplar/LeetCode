package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class WordLadderII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadderII instance=new WordLadderII();
		String start="hit";
		String end="cog";
		HashSet<String> dict=new HashSet<String>();
		dict.add("hot");
		dict.add("cog");
		dict.add("dot");
		dict.add("dog");
		dict.add("hit");
		dict.add("lot");
		dict.add("log");
		System.out.println(instance.findLadders(start, end, dict));
	}

	public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // method would be similar, except that, we need to store the path
        // in addition, if we get the result, we didn't stop until we finish
        // all the path of the same length
		// visited map the string to the list of its ancestor
		HashMap<String, HashSet<String>> visited=new HashMap<String, HashSet<String>>();
		HashMap<String, Integer> level=new HashMap<String, Integer>();
        LinkedList<String> queue=new LinkedList<String>();
        ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
        if (start==null || end==null || start.length()!=end.length())
        {
            return result;
        }
        // we also need to store the path from the start
        HashSet<String> path=new HashSet<String>();
        // we record the minimal length we get
        int min_length=Integer.MAX_VALUE;
        visited.put(start, path);
        level.put(start, 1);
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
                    // avoid circle
                    // check whether it is in the dictionary
                    // we only add the string which is nearer to the start
                    if (dict.contains(s2) && (!level.containsKey(s2) || (level.containsKey(s2) && level.get(s2)>level.get(s))))
                    {
                    	// we update the ancestor of the string
                    	if (visited.containsKey(s2))
                    	{
                    		visited.get(s2).add(s);
                    	}
                    	else
                    	{
                    		// we haven't seen this node before
                    		// thus we add it to the queue and also its ancestor
                    		path=new HashSet<String>();
                            path.add(s);
                            visited.put(s2, path);
                            level.put(s2, level.get(s)+1);
                    		queue.add(s2);
                    	}
                    }
                    if (s2.equals(end))
                    {
                        // we found it
                    	// we will use back trace to found its path to start
                        if (level.get(s)<min_length)
                        {
                            // it is shortest path
                        	ArrayList<String> entry=new ArrayList<String>();
                        	entry.add(end);
                            result.addAll(back_trace(s, visited, entry));
                            min_length=level.get(s)+1;
                        }
                        else
                        {
                            // ok, all the remaining path should be longer
                            break;
                        }
                    }
                }
                chars[i]=old;
            }
        }
        return result;
    }
	
	private ArrayList<ArrayList<String>> back_trace(String end, HashMap<String, HashSet<String>> visited, ArrayList<String> path)
	{
		ArrayList<ArrayList<String>> result=new ArrayList<ArrayList<String>>();
		ArrayList<String> entry=new ArrayList<String>(path);
		entry.add(0, end);
		if (visited.get(end).size()<1)
		{
			result.add(entry);
			return result;
		}
		for (String str: visited.get(end))
		{
			result.addAll(back_trace(str, visited, entry));
		}
		return result;
	}
}
