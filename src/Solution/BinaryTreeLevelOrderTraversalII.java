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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (root==null)
        {
            return result;
        }
        // the result of each level
        ArrayList<Integer> array=new ArrayList<Integer>();
        // the nodes to be visited
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        // record the depth of each node
        HashMap<TreeNode, Integer> depth=new HashMap<TreeNode, Integer>();
        int current_depth=1;
        queue.add(root);
        depth.put(root, 1);
        TreeNode node=null;
        while(!queue.isEmpty())
        {
            node=queue.remove();
            if (current_depth!=depth.get(node))
            {
                // finish a level
                result.add(array);
                array=new ArrayList<Integer>();
                current_depth=depth.get(node);
            }
            array.add(node.val);
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
        // for the leaf level
        result.add(array);
        return result;
    }
}
