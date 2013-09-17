package Solution;

public class Zigzag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // by a quick analysis, we have
        // first line: s[4*i]
        // second line: s[2*i=1]
        // third line: s[4*i+2]
        // for the special case
        if (nRows<=1)
        {
            return s;
        }
        // for generic case
        char []str=new char[s.length()];
        int period=2*(nRows-1);
        int k=0;
        for (int i=0; i<nRows; i++)
        {
            for (int j=0; j<=s.length()/period; j++)
            {
                if (i==0 || i==nRows-1)
                {
                    // for the corner
                    if (j*period+i<s.length())
                    {
                        str[k++]=s.charAt(j*period+i);
                    }
                }
                else
                {
                    // for all the other rows
                    if (j*period+i<s.length())
                    {
                        str[k++]=s.charAt(j*period+i);
                    }
                    if (j*period+period-i<s.length())
                    {
                        str[k++]=s.charAt(j*period+period-i);
                    }
                }
            }
        }
        return new String(str);
    }
}
