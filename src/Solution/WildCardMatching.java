package Solution;

public class WildCardMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildCardMatching instance=new WildCardMatching();
		if (instance.isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "aa"))
		{
			System.out.println("Match");
		}
		else
		{
			System.out.println("Unmatch");
		}
	}

	public boolean isMatch(String s, String p)
	{
		int i=0;
		int j=0;
		int ii=0;
		int jj=-1;
		if (s==null)
		{
			if (p==null)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		while(i<s.length())
		{
			if (j<p.length() && (p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)))
			{
				i++;
				j++;
				continue;
			}
			if (j<p.length() && p.charAt(j)=='*')
			{
				// save this position, in case we find an unmatch later
				jj=j++;
				ii=i;
				continue;
			}
			if (jj>=0 && jj<p.length())
			{
				// we found a unmatch
				// we need to go back to our last *
				j=jj+1;
				i=++ii;
				continue;
			}
			return false;
		}
		while(j<p.length() && p.charAt(j)=='*')
		{
			j++;
		}
		return j>=p.length();
	}
	
	public boolean isMatchSlow(String s, String p) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we want to use use recursion
        return isMatch(s, 0, p, 0);
    }
    
	private boolean isMatch(String s, int i, String p, int j)
    {
        if (p==null || j>=p.length())
        {
            if (s!=null && i<s.length())
            {
                // p finishes before s
                return false;
            }
            {
                // the two string matches
                // because they are emptu
                return true;
            }
        }
        // no match
        else if (s==null || i>=s.length() || (p.charAt(j)!='*' && p.charAt(j)!='?' && p.charAt(j)!=s.charAt(i)))
        {
            return false;
        }
        else if (p.charAt(j)=='*')
        {
            // for * we have three ways:
            // 1. skip it
            if (isMatch(s, i, p, j+1))
            {
                return true;
            }
            // 2. as a single match to s[i]
            else if(isMatch(s, i+1, p, j+1))
            {
                return true;
            }
            // 3. as a match to s[i] and its next
            else if(isMatch(s, i+1, p, j))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            // for ? and s[i]=s[j], we compre the next ones
            return isMatch(s, i+1, p, j+1);
        }
    }
}
