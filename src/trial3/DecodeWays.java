package trial3;

public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * dynamic programming. Say f(i) is the # of ways for S[0: i)
     * then we have f(i)=f(i-1)+f(i-2)
     */
    public int numDecodings(String s) {
        if (s==null || s.length()<1)
        {
            return 0;
        }
        int []result=new int[s.length()+1];
        result[0]=1;
        if (s.charAt(0)=='0')
        {
            result[1]=0;
        }
        else
        {
            result[1]=1;
        }
        for (int i=2; i<=s.length(); i++)
        {
            // try two char first
            if (s.charAt(i-2)!='0' && s.charAt(i-2)<'3' && !(s.charAt(i-2)=='2' && s.charAt(i-1)>'6'))
            {
                result[i]+=result[i-2];
            }
            // then single char
            if (s.charAt(i-1)!='0')
            {
                result[i]+=result[i-1];
            }
        }
        return result[s.length()];
    }
}
