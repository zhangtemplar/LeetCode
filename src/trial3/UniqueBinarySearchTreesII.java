package trial3;

import java.util.ArrayList;

public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * we will use a arrayList to store the list of all trees with nodes smaller than i
     */
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<ArrayList<TreeNode>> result=new ArrayList<ArrayList<TreeNode>>(n+1);
        // n<1
        ArrayList<TreeNode> level=new ArrayList<TreeNode>();
        level.add(null);
        result.add(level);
        if (n<1)
        {
            return level;
        }
        // n==1
        level=new ArrayList<TreeNode>();
        level.add(new TreeNode(1));
        result.add(level);
        if (n==1)
        {
            return level;
        }
        // for all other cases
        for (int i=2; i<=n; i++)
        {
            level=new ArrayList<TreeNode>();
            for (int j=0; j<i; j++)
            {
                // left tree
                ArrayList<TreeNode> left=result.get(j);
                // right tree
                ArrayList<TreeNode> right=result.get(i-j-1);
                for (TreeNode right_node: right)
                {
                    // we need to fix up the right tree, because their values are wrong
                    TreeNode right_node_fixed=fix(right_node, j+1);
                    // combine the root, left and right to get the final result
                    for (TreeNode left_node: left)
                    {
                        TreeNode root=new TreeNode(j+1);
                        root.left=left_node;
                        root.right=right_node_fixed;
                        level.add(root);
                    }
                }
            }
            result.add(level);
        }
        return result.get(n);
    }
    
    private TreeNode fix(TreeNode root, int value)
    {
        if (root==null)
        {
            return root;
        }
        else
        {
            TreeNode node=new TreeNode(root.val+value);
            if (root.left!=null)
            {
                node.left=fix(root.left, value);
            }
            if (root.right!=null)
            {
                node.right=fix(root.right, value);
            } 
            return node;
        }
    }
}
