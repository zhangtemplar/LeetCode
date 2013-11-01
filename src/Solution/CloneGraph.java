/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we use BFS to do the copy
        if (node==null)
        {
            return node;
        }
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> map)
    {
        if (map.containsKey(node))
        {
            return map.get(node);
        }
        else
        {
            UndirectedGraphNode entry=new UndirectedGraphNode(node.label);
            map.put(node, entry);
            for (UndirectedGraphNode element: node.neighbors)
            {
                entry.neighbors.add(cloneGraph(element, map));
            }
            return entry;
        }
    }
}
