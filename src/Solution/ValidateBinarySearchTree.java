package Solution;

import java.util.HashSet;
import java.util.Stack;

public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValidBST(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will perform a in-order traverse
        // where the output should be an array in ascending order
        Stack<TreeNode> stack=new Stack<TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        int value=Integer.MIN_VALUE;
        if (root==null)
        {
            return true;
        }
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            if (visited.contains(node))
            {
                // we have visited this node (to process its children)
                // we compare it to the value before it in in-order
                // it is no smaller than the previous value
                // we are good
                if (value<node.val)
                {
                    value=node.val;
                }
                // otherwise, there must be something wrong.
                else
                {
                    return false;
                }
            }
            else
            {
                if (node.right!=null)
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
