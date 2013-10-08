public class Solution {
    public int climbStairs(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // it is a recursion
        if (n<=1)
        {
            return 1;
        }
        buffer=new HashMap<Integer, Integer>();
        return subClimbStairs(n);
    }
    
    private static HashMap<Integer, Integer> buffer;
    
    private int subClimbStairs(int n)
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
            // we can either climb 2 steps or 1 step
            // which result in n-2 or n-1 steps to go
            result=subClimbStairs(n-1)+subClimbStairs(n-2);
        }
        buffer.put(n, result);
        return result;
    }
}
