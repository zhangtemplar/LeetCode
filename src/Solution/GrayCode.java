public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will assume for n=3, we have 0 1 3 2 6 7 5 4
        // we will use recursion, assume we have a[n] as the result for n
        // then a[n+1]={a[n] 2^(n-1)+a[-n]}, where a[-n] refers to a reverse order
        ArrayList<Integer> result=new ArrayList<Integer>();
        if (n<1)
        {
            result.add(0);
        }
        else
        {
            ArrayList<Integer> base=grayCode(n-1);
            for (Integer x: base)
            {
                result.add(x);
            }
            int offset=1<<(n-1);
            for (int i=base.size()-1; i>=0; i--)
            {
                result.add(offset+base.get(i));
            }
        }
        return result;
    }
}
