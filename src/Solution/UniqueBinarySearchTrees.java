public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion (or dynamic programming)
        // numTrees(n)=\sum_{i=0}^{n}{numTrees(i)*numTrees(n-i-1)}
        if (n<=0)
        {
            return 1;
        }
        buffer=new HashMap<Integer, Integer>();
        return subNumTrees(n);
    }
    
    private static HashMap<Integer, Integer> buffer;
    
    private int subNumTrees(int n)
    {
        if (buffer.containsKey(n))
        {
            return buffer.get(n);
        }
        int result=0;
        if (n<=1)
        {
            result=1;
        }
        else
        {
            for (int i=0; i<n; i++)
            {
                result+=subNumTrees(i)*subNumTrees(n-i-1);
            }
        }
        buffer.put(n, result);
        return result;
    }
}
