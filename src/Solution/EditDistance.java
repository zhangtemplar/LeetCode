public class Solution {
    public int minDistance(String word1, String word2) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will use dynamic programming
        // this is the standard dynamic programming problem
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
        else
        {
            // we use a dynamic prgoramming here
            // result[i][j] is the distance between two substrings 
            // word1[0:i-1] and word2[0:j-1]
            int [][]result=new int[word1.length()+1][word2.length()+1];
            // initialization
            // match word1[0: i-1] to a null string
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
                    // replace
                    if (word1.charAt(i-1)==word2.charAt(j-1))
                    {
                        result[i][j]=result[i-1][j-1];
                    }
                    else
                    {
                        result[i][j]=result[i-1][j-1]+1;
                    }
                    // insert
                    if (result[i][j]>result[i-1][j]+1)
                    {
                        result[i][j]=result[i-1][j]+1;
                    }
                    if (result[i][j]>result[i][j-1]+1)
                    {
                        result[i][j]=result[i][j-1]+1;
                    }
                }
            }
            return result[word1.length()][word2.length()];
        }
    }
}
