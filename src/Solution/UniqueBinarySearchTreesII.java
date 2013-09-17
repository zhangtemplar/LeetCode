package Solution;

import java.util.ArrayList;
import java.util.HashMap;

public class UniqueBinarySearchTreesII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII instance=new UniqueBinarySearchTreesII();
		ArrayList<TreeNode> result=instance.generateTrees(3);
		System.out.println(result);
	}

	public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion/dymaic programming
        // however, at each level of node, we are not storing the actual
        // value but its index in the least
        buffer=new HashMap<Integer, ArrayList<TreeNode>>();
        return subGenerateTrees(n);
    }
    
    private HashMap<Integer, ArrayList<TreeNode>> buffer;
    
    private ArrayList<TreeNode> subGenerateTrees(int n) 
    {
        ArrayList<TreeNode> result=new ArrayList<TreeNode>();
        if (buffer.containsKey(n))
        {
            return buffer.get(n);
        }
        else if (n<1)
        {
            // do nothing
            result.add(null);
        }
        else if (n==1)
        {
            TreeNode node=new TreeNode(1);
            result.add(node);
        }
        else
        {
            for (int i=0; i<n; i++)
            {
                ArrayList<TreeNode> left=subGenerateTrees(i);
                ArrayList<TreeNode> right=subGenerateTrees(n-i-1);
                for (TreeNode ltree: left)
                {
                    for (TreeNode rtree: right)
                    {
                        TreeNode root=new TreeNode(i+1);
                        // left tree is built with value 1 to i
                        root.left=assignValue(ltree, 1);
                        // right tree is built with value i+2 to n
                        root.right=assignValue(rtree, i+2);
                        result.add(root);
                    }
                }
            }
            
        }
        buffer.put(n, result);
        return result;
    }
    
    // this function perform a deep copy of the orginal tree and assgin propiate value to the tree
    private TreeNode assignValue(TreeNode root, int start)
    {
    	if (root==null)
    	{
    		return null;
    	}
        TreeNode result=new TreeNode(start+root.val-1);
        // perform recursion
        if (root.left!=null)
        {
            result.left=assignValue(root.left, start);
        }
        if (root.right!=null)
        {
            result.right=assignValue(root.right, start);
        }
        return result;
    }
}
