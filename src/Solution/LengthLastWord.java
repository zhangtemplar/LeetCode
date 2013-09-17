package Solution;

public class LengthLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public int lengthOfLastWord(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.length()<1)
        {
            return 0;
        }
        int prev_char=s.length()-1;
        // the flag for detection of a non-space char
        boolean flag=false;
        int i;
        for (i=s.length()-1; i>=0; i--)
        {
            if (s.charAt(i)==' ')
            {
                // it is a space
                if (flag)
                {
                    return prev_char-i;
                }
                else
                {
                    prev_char=i-1;
                }
            }
            else
            {
                flag=true;
            }
        }
        return prev_char-i;
    }
}
