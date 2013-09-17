package Solution;

import java.util.HashMap;

public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum instance=new BinaryTreeMaximumPathSum();
		TreeNode root=new TreeNode(2);
		root.left=new TreeNode(-1);
		System.out.println(instance.maxPathSum(root));
	}

	public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can use dynamic programming
        // maxPathSum can be generated in the following two scenarios
        // 1) the path is a pure top-down path
        // 2) the path is a combination of two top-down path, where
        //  the merge point is the lowest common ancestor of the two ends
        // so we compute and track the max of the sum of the path 
        // which has "node" as the top end
        if (root==null)
        {
            return 0;
        }
        buffer_single=new HashMap<TreeNode, Integer>();
        buffer_double=new HashMap<TreeNode, Integer>();
        maxSinglePathSum(root);
        return maxDoulePathSum(root);
    }
    
    private HashMap<TreeNode, Integer> buffer_single;
    
    private HashMap<TreeNode, Integer> buffer_double;
    
    /**
     * this function finds the maximum of all path within the subtree of root
     * note, there are following five possibilities
     * 1,2) the path has its toppest node as the left/right child of root
     * 3,4) the path has root as its topper end;
     * 5) the path is concatenated by the two paths from its and right
     */
    private int maxDoulePathSum(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        if (buffer_double.containsKey(root))
        {
        	return buffer_double.get(root);
        }
        // the path has root as its toper end
        int result=buffer_single.get(root);
        // or the path has root.left as the topest node (may or may not the end)
        if(root.left!=null)
        {
        	int tmp=maxDoulePathSum(root.left);
        	result=result>tmp?result:tmp;
        }
        // or the path has root.right as the topest node (may or may not the end)
        if (root.right!=null)
        {
        	int tmp=maxDoulePathSum(root.right);
        	result=result>tmp?result:tmp;
        }
        // or we can concatenate these two together
        if (root.left!=null && root.right!=null)
        {
        	int tmp=root.val+buffer_single.get(root.left)+buffer_single.get(root.right);
        	result=result>tmp?result:tmp;
        }
        buffer_double.put(root, result);
        return result;
    }
    
    /**
     * this function finds the maximum of all path has root as its top end
     */
    private int maxSinglePathSum(TreeNode root)
    {
        if (root==null)
        {
            return 0;
        }
        if (buffer_single.containsKey(root))
        {
            return buffer_single.get(root);
        }
        // we need to check its sum
        int result=0;
        if (root.left==null && root.right==null)
        {
            result=root.val;
        }
        else if(root.left==null)
        {
        	int tmp=maxSinglePathSum(root.right);
        	tmp=tmp>0?tmp:0;
            result=root.val+tmp;
        }
        else if(root.right==null)
        {
        	int tmp=maxSinglePathSum(root.left);
        	tmp=tmp>0?tmp:0;
            result=root.val+tmp;
        }
        else
        {
            // we need to compare the left and right
            int left=maxSinglePathSum(root.left);
            int right=maxSinglePathSum(root.right);
            if (left<0)
            {
            	left=0;
            }
            if (right<0)
            {
            	right=0;
            }
            result=root.val+(left>right?left:right);
        }
        // we can always reject the previous negative path
        // result=result>0?result:0;
        buffer_single.put(root, result);
        return result;
    }
}
