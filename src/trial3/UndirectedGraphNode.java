package trial3;

import java.util.ArrayList;

public class UndirectedGraphNode {
	int label;
	ArrayList<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) 
	{ 
		label = x; 
		neighbors = new ArrayList<UndirectedGraphNode>(); 
	}
}
