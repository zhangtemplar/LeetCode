package Solution;

import java.util.HashMap;
import java.util.LinkedList;

public class PopulatingNextRightPointersEachNodeII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can a level order traversal
        // use level-order traverse
        LinkedList<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        HashMap<TreeLinkNode, Integer> level=new HashMap<TreeLinkNode, Integer>();
        if (root==null)
        {
            return;
        }
        queue.add(root);
        level.put(root, 0);
        TreeLinkNode node, prev;
        node=null;
        prev=null;
        int height=0;
        while(!queue.isEmpty())
        {
            node=queue.remove();
            // add its children and their height accordingly
            if (node.left!=null)
            {
                queue.add(node.left);
                level.put(node.left, level.get(node)+1);
            }
            if (node.right!=null)
            {
                queue.add(node.right);
                level.put(node.right, level.get(node)+1);
            }
            // check whether we have finished the level or not
            if (level.get(node)!=height)
            {
                // we finish the previous level
                prev=null;
                height=level.get(node);
            }
            if (prev!=null)
            {
                prev.next=node;
            }
            prev=node;
        }
    }
}
