package trial3;

public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * this dynamic programming problem, say f(n) is the number of trees for n
     * then f(n)=\sum_{i=0}{f(i)*f(n-i-1)}
     * the point is that, a tree is built up with a root node, left subtree and
     * right subtree. 
     */
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<=1)
        {
            return 1;
        }
        int [] result=new int[n+1];
        // zero node
        result[0]=1;
        // one node
        result[1]=1;
        for (int i=2; i<=n; i++)
        {
            for (int j=0; j<i; j++)
            {
                // we take out a root node j+1
                result[i]+=result[j]*result[i-j-1];
            }
        }
        return result[n];
    }
}
