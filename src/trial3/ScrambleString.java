package trial3;

public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ScrambleString().isScramble("abc", "acb"));
	}
	/**
     * the most important step is identify the partition
     * dynamic programming, say f(i,j,k) is the result for s1[i:i+k] and s2[j:j+k]
     * then f(i,j,k)=any((f(i,i+l,j,j+l) AND f(i+l+1,i+k,j+l+1,j+k) OR (f(i,i+l,j+k-l,j+k) AND f(i+l+1,i+k,j,j+k-l-1))
     *  OR s1[i:i+k]==s2[j:j+k]
     * for any k: 0<=k<=q-p
     * the complexity would be O(N5)
     */
    public boolean isScramble(String s1, String s2) {
        if (s1==null || s2==null || s1.length()!=s2.length())
        {
            return false;
        }
        // match of s1[i:i+k] and s1[j:j+k] with dynamic programming
        boolean [][][]match=new boolean[s1.length()][s1.length()][s1.length()];
        for (int i=0; i<s1.length(); i++)
        {
            for (int j=0; j<s1.length(); j++)
            {
                for (int k=0; k+i<s1.length() && j+k<s1.length(); k++)
                {
                    if (k>0)
                    {
                        match[i][j][k]=match[i][j][k-1] & s1.charAt(i+k)==s2.charAt(j+k);
                    }
                    else
                    {
                        match[i][j][0]=s1.charAt(i)==s2.charAt(j);
                    }
                }
            }
        }
        // is scramble for s1[i:i+k] and s1[j:j+k] with dynamic programming
        // we can start from match
        for (int i=s1.length()-1; i>=0; i--)
        {
            for (int j=s1.length()-1; j>=0; j--)
            {
                for (int k=0; k+i<s1.length() && j+k<s1.length(); k++)
                {
                    if (match[i][j][k])
                    {
                        continue;
                    }
                    // for each partition
                    for (int l=0; l<=k; l++)
                    {
                        if ((match[i][j][l] && match[i+l+1][j+l+1][k-l-1]) || (match[i][j+k-l][l] && match[i+l+1][j][k-l-1]))
                        {
                            match[i][j][k]=true;
                            break;
                        }
                    }
                }
            }
        }
        return match[0][0][s1.length()-1];
    }
}
