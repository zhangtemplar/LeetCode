/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we can use a level order traverse
        // to mark the null node, we will use Long.MAX_VALUE
        if (root==null || (root.left==null && root.right==null))
        {
            return true;
        }
        // the value of nodes at the previous level
        ArrayList<Long> value=new ArrayList<Long>();
        // the list of queues to be visited
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        // to store the height
        HashMap<TreeNode, Integer> depth=new HashMap<TreeNode, Integer>();
        // to store the flag for a null node
        HashMap<TreeNode, Boolean> flag=new HashMap<TreeNode, Boolean>();
        depth.put(root, 1);
        queue.add(root);
        flag.put(root, true);
        int depth_current=1;
        TreeNode node=null;
        while(!queue.isEmpty())
        {
            node=queue.remove();
            // check whether we have finished a level or not
            if (depth_current!=depth.get(node))
            {
                // we have finished a level
                for (int i=0; i<value.size()-1-i; i++)
                {
                    if (!value.get(i).equals(value.get(value.size()-1-i)))
                    {
                        return false;
                    }
                }
                // so far so good, we start for the next level
                depth_current=depth.get(node);
                value=new ArrayList<Long>();
            }
            // check its children if this node is a fake node
            if (flag.get(node))
            {
                // add the value to the queue
                value.add((long) node.val);
                // add the children in
                if (node.left!=null)
                {
                    queue.add(node.left);
                    depth.put(node.left, depth.get(node)+1);
                    flag.put(node.left, true);
                }
                else
                {
                    TreeNode fake_node=new TreeNode(0);
                    queue.add(fake_node);
                    depth.put(fake_node, depth.get(node)+1);
                    flag.put(fake_node, false);
                }
                if (node.right!=null)
                {
                    queue.add(node.right);
                    depth.put(node.right, depth.get(node)+1);
                    flag.put(node.right, true);
                }
                else
                {
                    TreeNode fake_node=new TreeNode(0);
                    queue.add(fake_node);
                    depth.put(fake_node, depth.get(node)+1);
                    flag.put(fake_node, false);
                }
            }
            else
            {
                // for a fake node, we just add some value which can't exist
                value.add(Long.MAX_VALUE);
            }
        }
        // finish the leaf nodes
        for (int i=0; i<value.size()-1-i; i++)
        {
            if (!value.get(i).equals(value.get(value.size()-1-i)))
            {
                return false;
            }
        }
        return true;
    }
}
