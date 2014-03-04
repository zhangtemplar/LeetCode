package trial3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public ArrayList<Integer> postorderTraversal(TreeNode root) {
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
                visited.add(node);
                stack.push(node);
                if (node.right!=null)
                {
                    stack.push(node.right);
                }
                if (node.left!=null)
                {
                    stack.push(node.left);
                }
            }
        }
        return result;
    }
    
    /**
     * by recursion
     */
    public void postorderTraversal(TreeNode root, ArrayList<Integer> result)
    {
        if (root==null)
        {
            return;
        }
        else if (root.left==null && root.right==null)
        {
            result.add(root.val);
        }
        else
        {
            if (root.left!=null)
            {
                postorderTraversal(root.left, result);
                postorderTraversal(root.right, result);
                result.add(root.val);
            }
        }
    }
}
