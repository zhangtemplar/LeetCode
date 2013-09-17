package Solution;

public class UniqueBinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (n<=1)
        {
            return 1;
        }
        int []count=new int[n+1];
        count[0]=1;
        count[1]=1;
        for (int i=2; i<=n; i++)
        {
            for (int j=0; j<i; j++)
            {
                count[i]+=count[j]*count[i-j-1];
            }
        }
        return count[n];
    }
}
