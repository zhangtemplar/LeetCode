/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use level order traverse
        if (root==null)
        {
            return;
        }
        // depth
        HashMap<TreeLinkNode, Integer> depth=new HashMap<TreeLinkNode, Integer>();
        // node to be processed
        LinkedList<TreeLinkNode> queue=new LinkedList<TreeLinkNode>();
        // to store the node of current level
        ArrayList<TreeLinkNode> level=new ArrayList<TreeLinkNode>();
        int current_depth=1;
        depth.put(root, 1);
        queue.add(root);
        TreeLinkNode node=null;
        TreeLinkNode ptr=null;
        while(!queue.isEmpty())
        {
            node=queue.remove();
            if (depth.get(node)!=current_depth)
            {
                // we finish one level, process it
                for (int i=0; i<level.size()-1; i++)
                {
                    ptr=level.get(i);
                    ptr.next=level.get(i+1);
                }
                ptr=level.get(level.size()-1);
                ptr.next=null;
                // clear the buffer
                current_depth=depth.get(node);
                level=new ArrayList<TreeLinkNode>();
            }
            level.add(node);
            if (node.left!=null)
            {
                queue.add(node.left);
                depth.put(node.left, depth.get(node)+1);
            }
            if (node.right!=null)
            {
                queue.add(node.right);
                depth.put(node.right, depth.get(node)+1);
            }
        }
        // for the last level
        for (int i=0; i<level.size()-1; i++)
        {
            ptr=level.get(i);
            ptr.next=level.get(i+1);
        }
        ptr=level.get(level.size()-1);
        ptr.next=null;
    }
}
