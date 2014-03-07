package trial3;

import java.util.ArrayList;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        return pathSum(root, sum, new ArrayList<Integer>());
    }
    
    private ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum, ArrayList<Integer> base)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if (root==null)
        {
            return result;
        }
        else if (root.left==null && root.right==null)
        {
            if (sum==root.val)
            {
                ArrayList<Integer> path=new ArrayList<Integer>(base);
                path.add(root.val);
                result.add(path);
            }
            return result;
        }
        else
        {
            sum=sum-root.val;
            ArrayList<Integer> path=new ArrayList<Integer>(base);
            path.add(root.val);
            if (root.left!=null)
            {
                result.addAll(pathSum(root.left, sum, path));
            }
            
            if (root.right!=null)
            {
                result.addAll(pathSum(root.right, sum, path));
            }
            
            return result;
        }
    }
}
