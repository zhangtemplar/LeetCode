public class Solution {
    public int numDistinct(String S, String T) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use recursion
        if (S==null || T==null || S.length()<T.length())
        {
            return 0;
        }
        // we could use a dynamic programming
        // -1 means things haven't explored
        int[][] buffer=new int[S.length()+1][T.length()+1];
        // initialization
        // success case
        for (int i=0; i<=S.length(); i++)
        {
            buffer[i][T.length()]=1;
        }
        // progress
        for (int i=S.length()-1; i>=0; i--)
        {
            for (int j=T.length()-1; j>=0; j--)
            {
                if (S.charAt(i)==T.charAt(j))
                {
                    buffer[i][j]=buffer[i+1][j+1]+buffer[i+1][j];
                }
                else
                {
                    buffer[i][j]=buffer[i+1][j];
                }
            }
        }
        return buffer[0][0];
    }

    private int numDistinct(String S, int i, String T, int j)
    {
        if (j>=T.length())
        {
            return 1;
        }
        if (i>=S.length() || S.length()-i<T.length()-j)
        {
            return 0;
        }
        if (S.charAt(i)==T.charAt(j))
        {
            return numDistinct(S, i+1, T, j+1)+numDistinct(S, i+1, T, j);
        }
        else
        {
            return numDistinct(S, i+1, T, j);
        }
    }
}
