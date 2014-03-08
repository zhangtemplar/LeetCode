package trial3;

import java.util.ArrayList;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * use a level order traverse
     */
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root==null)
        {
            return true;
        }
        TreeNode nullNode=new TreeNode(0);
        ArrayList<TreeNode> curr=new ArrayList<TreeNode>();
        curr.add(root);
        while(!curr.isEmpty())
        {
            // check curr
            int i=0;
            int j=curr.size()-1;
            while(i<j)
            {
                if (!(curr.get(i)==nullNode && curr.get(j)==nullNode) && !(curr.get(i)!=nullNode && curr.get(j)!=nullNode && curr.get(i).val==curr.get(j).val))
                {
                    return false;
                }
                i++;
                j--;
            }
            ArrayList<TreeNode> next=new ArrayList<TreeNode>();
            for (TreeNode node: curr)
            {
                if (node==nullNode)
                {
                    continue;
                }
                if (node.left!=null)
                {
                    next.add(node.left);
                }
                else
                {
                    next.add(nullNode);
                }
                if (node.right!=null)
                {
                    next.add(node.right);
                }
                else
                {
                    next.add(nullNode);
                }
            }
            curr=next;
        }
        return true;
    }
}
