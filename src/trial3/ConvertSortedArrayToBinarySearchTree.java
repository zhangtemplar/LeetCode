package trial3;

public class ConvertSortedArrayToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public TreeNode sortedArrayToBST(int[] num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (num==null || num.length<1)
        {
            return null;
        }
        return sortedArrayToBST(num, 0, num.length-1);
    }
    
    private TreeNode sortedArrayToBST(int[] num, int start, int end)
    {
        if (start>end)
        {
            return null;
        }
        else if (start==end)
        {
            return new TreeNode(num[start]);
        }
        else
        {
            int middle=(start+end)/2;
            TreeNode root=new TreeNode(num[middle]);
            root.left=sortedArrayToBST(num, start, middle-1);
            root.right=sortedArrayToBST(num, middle+1, end);
            return root;
        }
    }
}
