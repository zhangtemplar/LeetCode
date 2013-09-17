package Solution;

public class ConvertSortArrayToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we use recursion
        // we find the medium as the root
        // then divide the array into two parts one for left subtree and the other
        // for right subtree
        if (num==null || num.length<1)
        {
            return null;
        }
        int middle=(num.length)/2;
        TreeNode root=new TreeNode(num[middle]);
        root.left=sortedArrayToBST(num, 0, middle-1);
        root.right=sortedArrayToBST(num, middle+1, num.length-1);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] num, int start, int end)
    {
        if (start>end)
        {
            return null;
        }
        int middle=(start+end+1)/2;
        TreeNode root=new TreeNode(num[middle]);
        if (start==end)
        {
            return root;
        }
        root.left=sortedArrayToBST(num, start, middle-1);
        root.right=sortedArrayToBST(num, middle+1, end);
        return root;
    }
}
