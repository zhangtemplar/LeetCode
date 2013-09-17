package Solution;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.length()<1)
        {
            return true;
        }
        s=s.toLowerCase();
        int i=0; 
        int j=s.length()-1;
        while(i<j)
        {
            if (!isDigit(s.charAt(i)))
            {
                i++;
            }
            else if(!isDigit(s.charAt(j)))
            {
                j--;
            }
            else
            {
                // both are alphabet, compare it
                if (s.charAt(i)!=s.charAt(j))
                {
                    return false;
                }
                else
                {
                    i++;
                    j--;
                }
            }
        }
        return true;
    }
    
    public boolean isDigit(char c)
    {
        return (c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9');
    }
}
