package trial3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * use a stack
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will stack to simulate the recursion
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (root==null)
        {
            return result;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            if (visited.contains(node))
            {
                result.add(node.val);
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
        return result;
    }
}
