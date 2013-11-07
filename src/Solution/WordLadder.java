public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (start.equals(end))
        {
            return 2;
        }
        // we will bfs search
        // the graph will have every word in the dictionary and start, end as the node
        // we add edge between two nodes, if they are only different by 1 letter
        HashSet<String> visited=new HashSet<String>();
        HashMap<String, Integer> depth=new HashMap<String, Integer>();
        LinkedList<String> queue=new LinkedList<String>();
        depth.put(start, 1);
        queue.add(start);
        while(!queue.isEmpty())
        {
            // process the head
            String str=queue.remove();
            if (str.equals(end))
            {
                return depth.get(str);
            }
            if (visited.contains(str))
            {
                continue;
            }
            visited.add(str);
            // this node is not visited before, we add its neighor to the queue
            char []tmp=str.toCharArray();
            // we try to alter one of its letter
            for (int i=0; i<tmp.length; i++)
            {
                for (char j='a'; j<='z'; j++)
                {
                    tmp[i]=j;
                    String s=new String(tmp);
                    // check it is in the dictionary and not visited yet
                    if (dict.contains(s) && !visited.contains(s) && !depth.containsKey(s))
                    {
                        if (s.equals(end))
                        {
                            return depth.get(str)+1;
                        }
                        // add this string to the queue
                        queue.add(s);
                        depth.put(s, depth.get(str)+1);
                    }
                }
                // recovery the altered char
                tmp[i]=str.charAt(i);
            }
        }
        // we finished the BFS from start, but haven't find end
        // so there is no such transform there
        return 0;
    }
}
