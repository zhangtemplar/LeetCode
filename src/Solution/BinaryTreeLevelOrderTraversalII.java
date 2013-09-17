package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use a stack for this purpose
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> base=levelOrder(root);
        for (int i=base.size()-1; i>=0; i--)
        {
            result.add(base.get(i));
        }
        return result;
    }
    
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // use level-order traverse
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> level=new HashMap<TreeNode, Integer>();
        ArrayList<Integer> value=new ArrayList<Integer>();
        if (root==null)
        {
            return result;
        }
        queue.add(root);
        level.put(root, 0);
        int height=0;
        while(!queue.isEmpty())
        {
            TreeNode node=queue.remove();
            // add its children and their height accordingly
            if (node.left!=null)
            {
                queue.add(node.left);
                level.put(node.left, level.get(node)+1);
            }
            if (node.right!=null)
            {
                queue.add(node.right);
                level.put(node.right, level.get(node)+1);
            }
            // check whether we have finished the level or not
            if (level.get(node)!=height)
            {
                // we finish the previous level
                // check wheher it is symmetric
                result.add(value);
                height=level.get(node);
                value=new ArrayList<Integer>();
            }
            value.add(node.val);
        }
        result.add(value);
        return result;
    }
}
