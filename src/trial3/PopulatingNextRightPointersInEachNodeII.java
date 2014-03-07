package trial3;

public class PopulatingNextRightPointersInEachNodeII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * we use the similar algorithm as the previous one
     * however, one difference is that, if root.next dosen't have
     * left child, we need to use its right one. if root.next is a leaf
     * we need to use root.next.next and so on
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
            TreeLinkNode next=findNext(root.next);
            // we need to process right child first, because it will be used by the left sibling
            if (root.right!=null)
            {
                root.right.next=next;
                connect(root.right);
            }
            
            if (root.left!=null)
            {
                if (root.right!=null)
                {
                    root.left.next=root.right;
                }
                else
                {
                    root.left.next=next;
                }
                connect(root.left);
            }
        }
    }
        
    private TreeLinkNode findNext(TreeLinkNode root)
    {
        while(root!=null)
        {
            if (root.left!=null)
            {
                return root.left;
            }
            else if (root.right!=null)
            {
                return root.right;
            }
            root=root.next;
        }
        return null;
    }
}
