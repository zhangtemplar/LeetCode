package trial3;

import java.util.HashMap;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return cloneGraph(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    private UndirectedGraphNode cloneGraph(UndirectedGraphNode node, HashMap<UndirectedGraphNode, UndirectedGraphNode> visited)
    {
        if (visited.containsKey(node))
        {
            return visited.get(node);
        }
        else
        {
            if (node==null)
            {
                return null;
            }
            UndirectedGraphNode cloned=new UndirectedGraphNode(node.label);
            visited.put(node, cloned);
            for (UndirectedGraphNode entry: node.neighbors)
            {
                UndirectedGraphNode entry_cloned=cloneGraph(entry, visited);
                cloned.neighbors.add(entry_cloned);
            }
            return cloned;
        }
    }
}
