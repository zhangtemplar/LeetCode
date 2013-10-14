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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion, for each node, we store the sum-(sum of value from root to this node).
        // if we find a leaf node and this value is zero, we add the path
        if (root==null)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        sum-=root.val;
        // leaf node, check whether this is a valid path
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (root.left==null && root.right==null)
        {
            // yes, this is a valid path
            if (sum==0)
            {
                ArrayList<Integer> path=new ArrayList<Integer>();
                path.add(root.val);
                result.add(path);
            }
        }
        // nonleaf node, we need to check the two subtree
        if (root.left!=null)
        {
            ArrayList<ArrayList<Integer>> base=pathSum(root.left, sum);
            // check the path
            for (ArrayList<Integer> entry: base)
            {
                ArrayList<Integer> path=new ArrayList<Integer>();
                path.add(root.val);
                path.addAll(entry);
                result.add(path);
            }
        }
        if (root.right!=null)
        {
            ArrayList<ArrayList<Integer>> base=pathSum(root.right, sum);
            // check the path
            for (ArrayList<Integer> entry: base)
            {
                ArrayList<Integer> path=new ArrayList<Integer>();
                path.add(root.val);
                path.addAll(entry);
                result.add(path);
            }
        }
        return result;
    }
}
