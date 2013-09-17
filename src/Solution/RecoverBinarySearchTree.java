package Solution;

import java.util.HashSet;
import java.util.Stack;

public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(3);
		root.right=new TreeNode(1);
		System.out.println(root);
		RecoverBinarySearchTree instance=new RecoverBinarySearchTree();
		instance.recoverTree(root);
		System.out.println(root);
	}

	public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use the same idea as "Validate Binary Search Tree"
        // however, when we met the first violation, we record the node
        // when we met the second violation, we swap this value with the value of recorded node
        Stack<TreeNode> stack=new Stack<TreeNode>();
        HashSet<TreeNode> visited=new HashSet<TreeNode>();
        // note that, when we met a violation, in fact, we wont't know 
        // which one is the violation, is the current one or previous one
        // so make it simple, we store this two
        TreeNode p_node=null;
        TreeNode c_node=null;
        TreeNode prev=null;
        TreeNode node=null;
        int c_value=Integer.MIN_VALUE;
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
                // we have visited this node (to process its children)
                // we compare it to the value before it in in-order
                // it is no smaller than the previous value
                // we are good
                if (c_value<node.val)
                {
                    c_value=node.val;
                }
                // otherwise, there must be something wrong.
                else if(c_node==null)
                {
                    // record it
                    c_node=node;
                    p_node=prev;
                    // recover the c_value
                    c_value=node.val;
                }
                else
                {
                    // we need to identify the pair of swapped node
                    // this is always the p_node and node
                    int swap=p_node.val;
                    p_node.val=node.val;
                    node.val=swap;
                    return;
                }
                prev=node;
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
        // there could be a special condition, where the violation happens to be adjacent
        int swap=p_node.val;
        p_node.val=c_node.val;
        c_node.val=swap;
    }
}
