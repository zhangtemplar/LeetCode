/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxPathSum(TreeNode root) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // there can be only two types of path
        //  all the path components are from children to parent
        //  this type of path can be obtained by joining two paths of the previous type
        if (root==null)
        {
            return 0;
        }
        HashMap<TreeNode, Integer> buffer=new HashMap<TreeNode, Integer>();
        singlePathSum(root, buffer);
        return doublePathSum(root, buffer);
    }
    
    private int doublePathSum(TreeNode root, HashMap<TreeNode, Integer> buffer)
    {
        if (root.left==null && root.right==null)
        {
            return buffer.get(root);
        }
        // at least, we can pick a path of Type 1
        int max=buffer.get(root);
        // check whether we can have better luck with path of Type 2
        if (root.left!=null && root.right!=null)
        {   
            max=Math.max(max, buffer.get(root.left)+buffer.get(root.right)+root.val);
        }
        // we also want to check the path without the root
        if (root.left!=null)
        {
            max=Math.max(max, doublePathSum(root.left, buffer));
        }
        if (root.right!=null)
        {
            max=Math.max(max, doublePathSum(root.right, buffer));
        }
        return max;
    }
    
    // we build a buffer, where the key is node and value is the maximal path, one of whose
    // terminal node is the node
    private int singlePathSum(TreeNode root, HashMap<TreeNode, Integer> buffer)
    {
        if (buffer.containsKey(root))
        {
            return buffer.get(root);
        }
        int max=0;
        // try to find left branche
        if (root.left!=null)
        {
            max=Math.max(max, singlePathSum(root.left, buffer));
        }
        // try to find the right branche
        if (root.right!=null)
        {
            max=Math.max(max, singlePathSum(root.right, buffer));
        }
        max=Math.max(root.val, max+root.val);
        buffer.put(root, max);
        return max;
    }
}
