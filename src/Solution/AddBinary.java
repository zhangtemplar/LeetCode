public class Solution {
    public String addBinary(String a, String b) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        StringBuffer result=new StringBuffer();
        char increment=0;
        for(int i=0; i<a.length() && i<b.length(); i++)
        {
            int x=a.charAt(a.length()-i-1)-'0'+b.charAt(b.length()-i-1)-'0'+increment;
            if (x>1)
            {
                x=x-2;
                increment=1;
            }
            else
            {
                increment=0;
            }
            result.insert(0, x);
        }
        if(a.length()>b.length())
        {
            for(int i=b.length(); i<a.length(); i++)
            {
                int x=a.charAt(a.length()-i-1)-'0'+increment;
                if (x>1)
                {
                    x=x-2;
                    increment=1;
                }
                else
                {
                    increment=0;
                }
                result.insert(0, x);
            }
        }
        else if(a.length()<b.length())
        {
            for(int i=a.length(); i<b.length(); i++)
            {
                int x=b.charAt(b.length()-i-1)-'0'+increment;
                if (x>1)
                {
                    x=x-2;
                    increment=1;
                }
                else
                {
                    increment=0;
                }
                result.insert(0, x);
            }
        }
        // for the extra x
        if (increment>0)
        {
            result.insert(0, '1');
        }
        return result.toString();
    }
}
