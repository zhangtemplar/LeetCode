package trial3;

import java.util.HashSet;
import java.util.Stack;

public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * use an inorder traverse
     */
    public boolean isValidBST(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we recursively compare the max of left subtree, value of root and minimal of right subtree for each subtree
        if (root==null)
        {
            return true;
        }
        // those values are use to identift a swap
        int prev=Integer.MIN_VALUE;
        Stack<TreeNode> stack=new Stack<TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        stack.add(root);
        // inorder traverse
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            if (visited.contains(node))
            {
                /* we find a violation
                 * there can be two situations: 
                 *  two adjacent nodes are swaped (easy case, just keep them)
                 *  two nonadjacent nodes are swaped
                */
                if (prev>=node.val)
                {
                    // we first assume the easy case
                    return false;
                }
                prev=node.val;
            }
            else
            {
                if(node.right!=null)
                {
                    stack.push(node.right);
                }
                visited.add(node);
                stack.push(node);
                if (node.left!=null)
                {
                    stack.push(node.left);
                }
            }
        }
        return true;
    }
}
