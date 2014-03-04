package trial3;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (root==null)
        {
            return result;
        }
        Stack<TreeNode> stack=new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty())
        {
            TreeNode node=stack.pop();
            result.add(node.val);
            if (node.right!=null)
            {
                stack.push(node.right);
            }
            if (node.left!=null)
            {
                stack.push(node.left);
            }
        }
        return result;
    }
}
