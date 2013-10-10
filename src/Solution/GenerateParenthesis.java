public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        // assume we have a[n] as the result for n, then a[n+1] can be built as follows
        // for each entry of a[n], we insert ( to every possible position and ) to every possible position after where we insert (
        // a simpler version
        // a[n+1]={a[1]a[n] a[n]a[1] a[2]a[n-2] a[n-2]a[2] ... a[n/2]a[(n+1)/2] a[(n+1)/2][n/2] (a[n])}
        // check the buffer first
        if (buffer.containsKey(n))
        {
            return buffer.get(n);
        }
        // then we need to get the result;
        ArrayList<String> result=new ArrayList<String>();
        if (n<1)
        {
            result.add("");
        }
        else if (n==1)
        {
            result.add("()");
        }
        else
        {
            HashSet<String> set=new HashSet<String>();
            // case 1
            for (int i=1; i<n; i++)
            {
                ArrayList<String> left=generateParenthesis(i);
                ArrayList<String> right=generateParenthesis(n-i);
                for (String entry_left: left)
                {
                    for (String entry_right: right)
                    {
                        set.add(new String(entry_left+entry_right));
                    }
                }
            }
            // case 2
            ArrayList<String> base=generateParenthesis(n-1);
            for (String entry: base)
            {
                set.add(new String("("+entry+")"));
            }
            for (String entry: set)
            {
                result.add(entry);
            }
        }
        buffer.put(n, result);
        return result;
    }
    
    private static HashMap<Integer, ArrayList<String>> buffer=new HashMap<Integer, ArrayList<String>>();
}
