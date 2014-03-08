package trial3;

import java.util.ArrayList;

public class BinaryTreeZigzagLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if  (root==null)
        {
            return result;
        }
        ArrayList<TreeNode> curr=new ArrayList<TreeNode>();
        curr.add(root);
        int direction=1;
        while(!curr.isEmpty())
        {
            ArrayList<TreeNode> next=new ArrayList<TreeNode>();
            ArrayList<Integer> level=new ArrayList<Integer>();
            if (direction==1)
            {
                direction=0;
                for (TreeNode node: curr)
                {
                    level.add(node.val);
                    if (node.left!=null)
                    {
                        next.add(node.left);
                    }
                    if (node.right!=null)
                    {
                        next.add(node.right);
                    }
                }
            }
            else
            {
                direction=1;
                for (TreeNode node: curr)
                {
                    level.add(0, node.val);
                    if (node.left!=null)
                    {
                        next.add(node.left);
                    }
                    if (node.right!=null)
                    {
                        next.add(node.right);
                    }
                }
            }
            result.add(level);
            curr=next;
        }
        return result;
    }
}
