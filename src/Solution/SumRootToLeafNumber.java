package Solution;

import java.util.HashMap;

public class SumRootToLeafNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumRootToLeafNumber instance=new SumRootToLeafNumber();
		TreeNode root=new TreeNode(0);
		root.left=new TreeNode(1);
		root.right=new TreeNode(3);
		System.out.println(instance.sumNumbers(root));
	}

	public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root==null)
        {
            return 0;
        }
        buffer=new HashMap<TreeNode, Long>();
        buffer.put(root, (long) root.val);
        return (int) sumNumbers(root, 0);
    }
    
    private long sumNumbers(TreeNode root, long base)
    {
        if (root.left==null && root.right==null)
        {
            return base+buffer.get(root);
        }
        if (root.left!=null)
        {
            buffer.put(root.left, buffer.get(root)*10+root.left.val);
            base=sumNumbers(root.left, base);
        }
        if (root.right!=null)
        {
            buffer.put(root.right, buffer.get(root)*10+root.right.val);
            base=sumNumbers(root.right, base);
        }
        return base;
    }
    
    private HashMap<TreeNode, Long>buffer;
}
