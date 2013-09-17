package Solution;

public class String2Integer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(atoi("    10522545459"));
	}

	public static int atoi(String str) {
		// Start typing your Java solution below
        // DO NOT write main() function
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign=1;
        // whether the symbol is already visisted
        boolean flag=true;
        int result=0;
        for (int i=0; i<str.length(); i++)
        {
            if (flag && str.charAt(i)==' ')
            {
                // empty space at the left, skip it
                continue;
            }
            else if (str.charAt(i)=='-')
            {
                // f;p the sign
                if (!flag)
                {
                    return 0;
                }
                sign=-1*sign;
                flag=false;
            }
            else if (str.charAt(i)=='+')
            {
                // nothing happened for the sign
                if (!flag)
                {
                    return 0;
                }
                flag=false;
                continue;
            }
            else if (str.charAt(i)>='0' && str.charAt(i)<='9')
            {
                // the digit
            	if (result>214748364 || (result==214748364 && (str.charAt(i)-'0')>7))
            	{
            		if (sign>0)
                    {
                        return Integer.MAX_VALUE;
                    }
                    else
                    {
                        return Integer.MIN_VALUE;
                    }
            	}
                result=result*10+str.charAt(i)-'0';
                flag=false;
            }
            else
            {
                // all other chars are not allowed
                break;
            }
        }
        return sign*result;
    }
}
