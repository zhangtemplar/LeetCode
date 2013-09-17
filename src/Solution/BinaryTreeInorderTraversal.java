package Solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class BinaryTreeInorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
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
                // we have visisted it before
                result.add(node.val);
            }
            else
            {
                // first time visis
                visited.add(node);
                // push the left node and right node in
                if (node.right!=null)
                {
                    stack.push(node.right);
                }
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

 class TreeNode
 {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
     
     public String toString()
     {
    	 // use level-order traverse
    	 StringBuffer result=new StringBuffer();
    	 LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
    	 queue.add(this);
    	 result.append('{');
    	 while(!queue.isEmpty())
    	 {
    		 TreeNode node=queue.remove();
    		 if (node!=null)
    		 {
    			 result.append(node.val);
    			 result.append(',');
    			 queue.add(node.left);
    			 queue.add(node.right);
    		 }
    		 else
    		 {
    			 result.append("#,");
    		 }
    	 }
    	 result.setCharAt(result.length()-1, '}');
    	 return result.toString();
     }
}