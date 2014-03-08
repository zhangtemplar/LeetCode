package trial3;

import java.util.ArrayList;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * we use arraylist to store the nodes of each level
     * then stack to get the bottom-up order
     */
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
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
            result.add(0, level);
            curr=next;
        }
        return result;
    }
}
