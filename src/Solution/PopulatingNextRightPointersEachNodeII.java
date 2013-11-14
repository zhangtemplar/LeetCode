/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        // however, since the tree is no longer complete, we can not use something like
        // root.left.right.next=root.right.left, because it can be no such points,
        // the solution is that, we always return the rightmost(leftmost) for the function
        if (root==null)
        {
            return;
        }
        // for left child, we find the leftmost child of its root or the next of its root
        if (root.left!=null)
        {
            if (root.right!=null)
            {
                root.left.next=root.right;
            }
            else
            {
                TreeLinkNode node=root.next;
                while(node!=null)
                {
                    if (node.left!=null)
                    {
                        root.left.next=node.left;
                        break;
                    }
                    else if(node.right!=null)
                    {
                        root.left.next=node.right;
                        break;
                    }
                    node=node.next;
                }
            }
        }
        // similarly for right child
        if (root.right!=null)
        {
            TreeLinkNode node=root.next;
            while(node!=null)
            {
                if (node.left!=null)
                {
                    root.right.next=node.left;
                    break;
                }
                else if(node.right!=null)
                {
                    root.right.next=node.right;
                    break;
                }
                node=node.next;
            }
        }
        // process the child node
        // it is important to start with right subtree first, because we require the next information
        // in the previous step
        if (root.right!=null)
        {
            connect(root.right);
        }
        if (root.left!=null)
        {
            connect(root.left);
        }
    }
}
