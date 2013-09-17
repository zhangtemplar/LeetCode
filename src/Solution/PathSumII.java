package Solution;

import java.util.ArrayList;

public class PathSumII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return pathSum(root, sum, new ArrayList<Integer>());
    }
    
    // path is the current partial path
    private ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum, ArrayList<Integer> path)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (root==null)
        {
            return result;
        }
        sum=sum-root.val;
        ArrayList<Integer> new_path=new ArrayList<Integer>(path);
        new_path.add(root.val);
        // this is a leaf node
        if (root.left==null && root.right==null)
        {
            if (sum==0)
            {
                result.add(new_path);
            }
            return result;
        }
        // otherwise check it children
        if (root.left!=null)
        {
            ArrayList<ArrayList<Integer>> base=pathSum(root.left, sum, new_path);
            for (ArrayList<Integer> entry: base)
            {
                result.add(entry);
            }
        }
        if (root.right!=null)
        {
            ArrayList<ArrayList<Integer>> base=pathSum(root.right, sum, new_path);
            for (ArrayList<Integer> entry: base)
            {
                result.add(entry);
            }
        }
        return result;
    }
}
