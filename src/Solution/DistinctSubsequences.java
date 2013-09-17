package Solution;

public class DistinctSubsequences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DistinctSubsequences instance=new DistinctSubsequences();
		System.out.println(instance.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe", "bddabdcae"));
	}

	public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use dynamic programming
        if (S==null || S.length()<1)
        {
             if (T==null || T.length()<1)
             {
                 return 1;
             }
             else
             {
                 return 0;
             }
        }
        else if (T==null || T.length()<1)
        {
            return 1;
        }
        else if (S.length()<T.length())
        {
            return 0;
        }
        // result[i][j] is the # of such match for S[0:i] and T[0:j]
        int [][]result=new int[S.length()][T.length()];
        if (S.charAt(0)==T.charAt(0))
        {
            result[0][0]=1;
        }
        else
        {
            result[0][0]=0;
        }
        for (int j=1; j<T.length(); j++)
        {
            result[0][j]=0;
        }
        for (int i=1; i<S.length(); i++)
        {
            if (S.charAt(i)==T.charAt(0))
            {
                result[i][0]=result[i-1][0]+1;
            }
            else
            {
                result[i][0]=result[i-1][0];
            }
        }
        for (int i=1; i<S.length(); i++)
        {
            for (int j=1; j<T.length(); j++)
            {
                if (S.charAt(i)==T.charAt(j))
                {
                    result[i][j]=result[i-1][j]+result[i-1][j-1];
                }
                else
                {
                    result[i][j]=result[i-1][j];
                }
            }
        }
        return result[S.length()-1][T.length()-1];
    }
	
	public int numDistinctSlow(String S, String T) {
		// Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion
        // in each level, we try to remove one of the letter from S, until 
        // S is the same long as T
        // Note that, to avoid duplicate, we only remove the letter which is
        // after the removal of previous step
        if (S==null || S.length()<1)
        {
             if (T==null || T.length()<1)
             {
                 return 1;
             }
             else
             {
                 return 0;
             }
        }
        else if (T==null || T.length()<1)
        {
            return 1;
        }
        else if (S.length()<T.length())
        {
            return 0;
        }
        return numDistinct(S, 0, T, 0);
    }
	
	private int numDistinct(String S, int start1, String T, int start2)
    {
		if (start2>=T.length())
		{
			// the search has finished
			return 1;
		}
        // main algorithm
        int result=0;
        // instead of trying every possible location, we in fact 
        // only check the possible ones
        int i=start1;
        while(S.length()-i>=T.length()-start2)
        {
            if (S.charAt(i)==T.charAt(start2))
            {
                // this is a valid starting location
                // however we have two possibilties, use it or skip it
                // use it
                result+=numDistinct(S, i+1, T, start2+1);
            }
            i++;
        }
        return result;
    }
}
