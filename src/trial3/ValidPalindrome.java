package trial3;

public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public boolean isPalindrome(String s) {
        if (s==null)
        {
            return false;
        }
        else if (s.length()<=1)
        {
            return true;
        }
        int i=0;
        int j=s.length()-1;
        while(i<j)
        {
            char x=s.charAt(i);
            // not char
            if (!(x>='a' && x<='z') && !(x>='A' && x<='Z') && !(x>='0' && x<='9'))
            {
                i++;
                continue;
            }
            
            char y=s.charAt(j);
            // not char
            if (!(y>='a' && y<='z') && !(y>='A' && y<='Z') && !(y>='0' && y<='9'))
            {
                j--;
                continue;
            }
            
            // convert lower case to upper one
            if (x>='a')
            {
                x=(char) (x-'a'+'A');
            }
            if (y>='a')
            {
                y=(char) (y-'a'+'A');
            }
            // compare it
            if (x!=y)
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
