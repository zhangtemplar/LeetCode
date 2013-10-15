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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // to reverse the order, we will use add(0, x) of arraylist
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (root==null)
        {
            return result;
        }
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> depth=new HashMap<TreeNode, Integer>();
        queue.add(root);
        depth.put(root, 1);
        ArrayList<Integer> entry=new ArrayList<Integer>();
        int level=1;
        while(!queue.isEmpty())
        {
            TreeNode node=queue.remove();
            // we finish a level
            if (level!=depth.get(node))
            {
                result.add(entry);
                level=depth.get(node);
                entry=new ArrayList<Integer>();
            }
            // add new node
            // left to right
            if (level%2==1)
            {
                entry.add(node.val);
            }
            // right to left
            else
            {
                entry.add(0, node.val);
            }
            // add left child
            if (node.left!=null)
            {
                queue.add(node.left);
                depth.put(node.left, depth.get(node)+1);
            }
            // add right child
            if (node.right!=null)
            {
                queue.add(node.right);
                depth.put(node.right, depth.get(node)+1);
            }
        }
        // for the last level
        result.add(entry);
        return result;
    }
}
