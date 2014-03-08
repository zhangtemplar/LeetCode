package trial3;

import java.util.HashSet;
import java.util.Stack;

public class RecoverBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * those number should be identifiable by checking the inorder traverse
     * if the order changes, then there will be a mistake there
     */
    public void recoverTree(TreeNode root) {
        // the two swapped node
        TreeNode x, y;
        x=null;
        y=null;
        if (root==null)
        {
            return;
        }
        // those values are use to identift a swap
        int min=Integer.MIN_VALUE;
        TreeNode prev=null;
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
                if (min>node.val)
                {
                    // we first assume the easy case
                    if (x==null)
                    {
                        x=prev;
                        y=node;
                    }
                    // we found another violation, this means the second case
                    else
                    {
                        y=node;
                        break;
                    }
                }
                min=node.val;
                prev=node;
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
        // swap x and y
        if (x!=null && y!=null)
        {
            int tmp=x.val;
            x.val=y.val;
            y.val=tmp;
        }
    }
}
