public class Solution {
    public String countAndSay(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        if (n<1)
        {
            return new String("");
        }
        else if(n==1)
        {
            return new String("1");
        }
        else
        {
            StringBuffer result=new StringBuffer();
            String base=countAndSay(n-1);
            int count=1;
            int i=0;
            for (i=1; i<base.length(); i++)
            {
                if (base.charAt(i)!=base.charAt(i-1))
                {
                    result.append(count);
                    result.append(base.charAt(i-1));
                    count=1;
                }
                else
                {
                    count++;
                }
            }
            // for the last one
            result.append(count);
            result.append(base.charAt(i-1));
            return result.toString();
        }
    }
}
