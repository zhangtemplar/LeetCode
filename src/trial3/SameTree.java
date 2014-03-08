package trial3;

public class SameTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        if (p==null)
        {
            return q==null;
        }
        else if (q==null)
        {
            return false;
        }
        else
        {
            if (p.val!=q.val)
            {
                return false;
            }
            else
            {
                if (p.left!=null)
                {
                    if (q.left==null)
                    {
                        return false;
                    }
                    else if (!isSameTree(p.left, q.left))
                    {
                        return false;
                    }
                }
                else if (q.left!=null)
                {
                    return false;
                }
                
                if (p.right!=null)
                {
                    if (q.right==null)
                    {
                        return false;
                    }
                    else if (!isSameTree(p.right, q.right))
                    {
                        return false;
                    }
                }
                else if (q.right!=null)
                {
                    return false;
                }
                
                return true;
            }
        }
    }
}
