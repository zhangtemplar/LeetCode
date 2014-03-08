package trial3;

public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * we need to use dynamic programming
     * say f(i,j) is the result for s1[0:i-1], s2[0:j-1], s3:[0:i+j-1]
     * then we have f(i,j)=f(i-1,j) || f(i, j-1), if condition holds
     * we have f(0,0)=1
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1==null || s2==null || s3==null || s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
        boolean [][]result=new boolean[s1.length()+1][s2.length()+1];
        result[0][0]=true;
        for (int i=1; i<=s1.length(); i++)
        {
            result[i][0]=result[i-1][0] && s1.charAt(i-1)==s3.charAt(i-1);
        }
        for (int j=1; j<=s2.length(); j++)
        {
            result[0][j]=result[0][j-1] && s2.charAt(j-1)==s3.charAt(j-1);
        }
        
        for (int i=1; i<=s1.length(); i++)
        {
            for (int j=1; j<=s2.length(); j++)
            {
                result[i][j]=(result[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1)) || (result[i][j-1] && s2.charAt(j-1)==s3.charAt(i+j-1));
            }
        }
        return result[s1.length()][s2.length()];
    }
}
