package trial3;

public class DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
     * we can use dynamic programming
     * say f(i,j) is the # of match for substring S[0:i] and T[0:j]
     * then we have f(i,j)=f(i-1,j-1)+f(i-1,j), if S[i]==T[j]
     * or f(i,j)=f(i-1,j)
     */
    public int numDistinct(String S, String T) {
        if (S==null || T==null || S.length()<T.length())
        {
            return 0;
        }
        else if (T.length()<1)
        {
            return 1;
        }
        int [][]result=new int[S.length()+1][T.length()+1];
        result[0][0]=1;
        for (int i=1; i<=S.length(); i++)
        {
            result[i][0]=1;
            for (int j=1; j<=T.length(); j++)
            {
                // S[i]==T[j], we either take S[i] and T[j] into the match
                // or we just skip S[i]
                if (S.charAt(i-1)==T.charAt(j-1))
                {
                    result[i][j]=result[i-1][j-1]+result[i-1][j];
                }
                else
                {
                    // we have no choice but to skip S[i]
                    result[i][j]=result[i-1][j];
                }
            }
        }
        return result[S.length()][T.length()];
    }
}
