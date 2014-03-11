package trial3;

public class EditDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * dynamic programming, say d(i,j) is the distance for s1[0:i-1] and s2[0:j-1]
     * then d(i,j)=min(d(i-1,j),d(i,j-1),d(i-1,j-1))
     */
    public int minDistance(String word1, String word2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (word1==null || word1.length()<1)
        {
            if (word2==null || word2.length()<1)
            {
                return 0;
            }
            else
            {
                return word2.length();
            }
        }
        else if (word2==null || word2.length()<1)
        {
            return word1.length();
        }
        int [][]result=new int[word1.length()+1][word2.length()+1];
        result[0][0]=0;
        for (int i=1; i<=word1.length(); i++)
        {
            result[i][0]=i;
        }
        for (int j=1; j<=word2.length(); j++)
        {
            result[0][j]=j;
        }
        for (int i=1; i<=word1.length(); i++)
        {
            for (int j=1; j<=word2.length(); j++)
            {
                result[i][j]=Integer.MAX_VALUE;
                // match
                if (word1.charAt(i-1)==word2.charAt(j-1))
                {
                    result[i][j]=result[i-1][j-1];
                }
                // mismatch, replace
                else
                {
                    result[i][j]=result[i-1][j-1]+1;
                }
                // mismatch, delete in word1
                if (result[i][j]>result[i-1][j])
                {
                    result[i][j]=result[i-1][j]+1;
                }
                // mismatch, insert in word2
                if (result[i][j]>result[i][j-1])
                {
                    result[i][j]=result[i][j-1]+1;
                }
            }
        }
        return result[word1.length()][word2.length()];
    }
}
