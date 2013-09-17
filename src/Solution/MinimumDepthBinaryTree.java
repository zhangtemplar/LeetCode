package Solution;

import java.util.HashMap;
import java.util.LinkedList;

public class MinimumDepthBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minDepth(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use BFS
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> level=new HashMap<TreeNode, Integer>();
        if (root==null)
        {
            return 0;
        }
        queue.add(root);
        level.put(root, 1);
        TreeNode node=null;
        while(!queue.isEmpty())
        {
            node=queue.remove();
            if (node.left==null && node.right==null)
            {
                break;
            }
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
        }
        return level.get(node);
    }
}
