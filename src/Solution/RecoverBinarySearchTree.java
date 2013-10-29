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
    public void recoverTree(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // by performing a in-order traverse, we can identify the node whose order is wrong
        if (root==null)
        {
            return;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        HashSet<TreeNode> visit=new HashSet<TreeNode>();
        int min=Integer.MIN_VALUE;
        TreeNode left=null;
        TreeNode right=null;
        TreeNode prev=null;
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            if (visit.contains(node))
            {
                // there must be something wrong with this node
                if (min>node.val)
                {
                    // we have found an error before
                    if (left!=null)
                    {
                        int val=left.val;
                        left.val=node.val;
                        node.val=val;
                        return;
                    }
                    // we need to save this node, in case the two nodes are adjacent
                    else
                    {
                        left=prev;
                        right=node;
                    }
                }
                min=node.val;
                prev=node;
            }
            else
            {
                visit.add(node);
                if (node.right!=null)
                {
                    stack.push(node.right);
                }
                stack.push(node);
                if(node.left!=null)
                {
                    stack.push(node.left);
                }
            }
        }
        // in case the swaped node are adjacent
        int val=left.val;
        left.val=right.val;
        right.val=val;
    }
}
