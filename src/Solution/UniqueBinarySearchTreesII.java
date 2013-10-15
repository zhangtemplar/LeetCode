/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will dynamic programming as the previous problem
        if (n<1)
        {
            ArrayList<TreeNode> result=new ArrayList<TreeNode>();
            result.add(null);
            return result;
        }
        else
        {
            return generateTrees(1, n);
        }
    }
    
    private ArrayList<TreeNode> generateTrees(int start, int end)
    {
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if (start==end)
        {
            result.add(new TreeNode(start));
        }
        else if (start<end)
        {
            for (int i=start; i<=end; i++)
            {
                // root is built with i
                // left subtree is built with start:i-1
                ArrayList<TreeNode> left=generateTrees(start, i-1);
                // right subtree is built with i+1:end
                ArrayList<TreeNode> right=generateTrees(i+1, end);
                // mix the trees
                if (!left.isEmpty() && !right.isEmpty())
                {
                    for(TreeNode lnode: left)
                    {
                        for (TreeNode rnode: right)
                        {
                            TreeNode root=new TreeNode(i);
                            root.left=lnode;
                            root.right=rnode;
                            result.add(root);
                        }
                    }
                }
                else if(!left.isEmpty())
                {
                    for (TreeNode lnode: left)
                    {
                        TreeNode root=new TreeNode(i);
                        root.left=lnode;
                        result.add(root);
                    }
                }
                else if(!right.isEmpty())
                {
                    for(TreeNode rnode: right)
                    {
                        TreeNode root=new TreeNode(i);
                        root.right=rnode;
                        result.add(root);
                    }
                }
            }
        }
        return result;
    }
}
