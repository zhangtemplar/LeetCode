package trial3;

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
     * we will use a recursion
     */
    public void connect(TreeLinkNode root) {
        if (root==null)
        {
            return;
        }
        else if (root.left==null && root.right==null)
        {
            return;
        }
        else
        {
            root.left.next=root.right;
            if (root.next!=null)
            {
                root.right.next=root.next.left;
            }
            connect(root.left);
            connect(root.right);
        }
    }
}
