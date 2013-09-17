package Solution;

public class ParlindromeNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (x<0)
        {
            return false;
        }
        long y=reverse((long) x);
        if (y==(long) x)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public long reverse(long x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // for negative value
        if (x<0)
        {
            return -reverse(-x);
        }
        // for common case
        // however, a potential pitfall is the overflow
        long y=0;
        while (x>0)
        {
            y=y*10+x%10;
            if (y<0)
            {
                // System.out.println("Overflow happens");
                return y;
            }
            x=x/10;
        }
        return y;
    }
}
