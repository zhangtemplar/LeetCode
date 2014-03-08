package trial3;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (root==null)
        {
            return result;
        }
        ArrayList<TreeNode> curr=new ArrayList<TreeNode>();
        curr.add(root);
        while(!curr.isEmpty())
        {
            ArrayList<TreeNode> next=new ArrayList<TreeNode>();
            ArrayList<Integer> level=new ArrayList<Integer>();
            for (TreeNode node: curr)
            {
                if (node.left!=null)
                {
                    next.add(node.left);
                }
                if (node.right!=null)
                {
                    next.add(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
            curr=next;
        }
        return result;
    }
}
