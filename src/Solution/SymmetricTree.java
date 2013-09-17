package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		root.left=new TreeNode(2);
		root.right=new TreeNode(2);
		root.left.right=new TreeNode(3);
		root.right.left=new TreeNode(3);
		System.out.println(root);
		SymmetricTree instance=new SymmetricTree();
		System.out.println(instance.isSymmetric(root));
	}

	public boolean isSymmetric(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we simplest way is of course using recursion
        // however, we can also use stack to make it iteratively
        // we will perform level order traverse
        LinkedList<TreeNode> queue=new LinkedList<TreeNode>();
        HashMap<TreeNode, Integer> level=new HashMap<TreeNode, Integer>();
        ArrayList<Integer> value=new ArrayList<Integer>();
        if (root==null)
        {
            return true;
        }
        queue.add(root);
        level.put(root, 0);
        int height=0;
        while(!queue.isEmpty())
        {
            TreeNode node=queue.remove();
            if (node.val!=Integer.MIN_VALUE)
            {
                // add its children and their height accordingly
                if (node.left!=null)
                {
                    queue.add(node.left);
                    level.put(node.left, level.get(node)+1);
                }
                else
                {
                    TreeNode fake=new TreeNode(Integer.MIN_VALUE);
                    queue.add(fake);
                    level.put(fake, level.get(node)+1);
                }
                if (node.right!=null)
                {
                    queue.add(node.right);
                    level.put(node.right, level.get(node)+1);
                }
                else
                {
                    TreeNode fake=new TreeNode(Integer.MIN_VALUE);
                    queue.add(fake);
                    level.put(fake, level.get(node)+1);
                }
            }
            // check whether we have finished the level or not
            if (level.get(node)!=height)
            {
                // we finish the previous level
                // check wheher it is symmetric
                if (height!=0 && value.size()%2!=0)
                {
                    return false;
                }
                else
                {
                    // check the value
                    for (int i=0; i<value.size()-i; i++)
                    {
                    	// note we can't use value.get(i).!=value.get(value.size()-i-1) here
                    	// because we are dealing objects, which are compared according to hashcode
                        if (!value.get(i).equals(value.get(value.size()-i-1)))
                        {
                            return false;
                        }
                    }
                }
                height=level.get(node);
                value.clear();
            }
            value.add(node.val);
        }
        return true;
    }
}
