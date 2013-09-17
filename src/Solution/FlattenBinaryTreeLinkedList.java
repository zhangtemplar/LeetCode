package Solution;

import java.util.HashSet;
import java.util.Stack;

public class FlattenBinaryTreeLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // sounds like an preorder traversal node left right
        // we use recursion
        Stack<TreeNode> stack=new Stack<TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        TreeNode node=null;
        TreeNode prev=null;
        if (root==null)
        {
            return;
        }
        stack.push(root);
        while(!stack.isEmpty())
        {
            node=stack.pop();
            if (visited.contains(node))
            {
                if(node!=root)
                {
                    prev.right=node;
                    prev.left=null;
                }
                prev=node;
                continue;
            }
            if(node.right!=null)
            {
                stack.push(node.right);
            }
            if (node.left!=null)
            {
                stack.push(node.left);
            }
            visited.add(node);
            stack.push(node);
        }
        node.left=null;
        node.right=null;
    }
}
