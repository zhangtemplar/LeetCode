public class Solution {
    public String convert(String s, int nRows) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we just need to find a proper index
        if (nRows<2)
        {
            return s;
        }
        int step=2*(nRows-1);
        StringBuffer result=new StringBuffer();
        // row 0
        for (int j=0; ; j++)
        {
            int k=j*step;
            if (k>=s.length())
            {
                break;
            }
            else
            {
                result.append(s.charAt(k));
            }
        }
        // middle
        for (int i=1; i<nRows-1; i++)
        {
            for (int j=0; ; j++)
            {
                int k=j*step+i;
                if (k>=s.length())
                {
                    break;
                }
                else
                {
                    result.append(s.charAt(k));
                }
                
                k=(j+1)*step-i;
                if (k>=s.length())
                {
                    break;
                }
                else
                {
                    result.append(s.charAt(k));
                }
            }
        }
        // last row
        for (int j=0; ; j++)
        {
            int k=j*step+nRows-1;
            if (k>=s.length())
            {
                break;
            }
            else
            {
                result.append(s.charAt(k));
            }
        }
        return result.toString();
    }
}
