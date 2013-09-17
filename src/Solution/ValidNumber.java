package Solution;

public class ValidNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidNumber instance=new ValidNumber();
//		System.out.println(instance.isNumber("2.3."));
//		System.out.println(instance.isNumber("    1.2    0"));
//		System.out.println(instance.isNumber("1"));
		System.out.println(instance.isNumber(" 0.1 "));
//		System.out.println(instance.isNumber("1 a"));
//		System.out.println(instance.isNumber("abc"));
//		System.out.println(instance.isNumber("4e10"));
	}

	public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s==null || s.length()<1)
        {
            return false;
        }
        // whether we have met any none space before
        int flag_space=0;
        // whether we have met the sign before
        int flag_sign=0;
        // whether we have met the e before
        int flag_e=0;
        // whether we have met the dot before
        int flag_dot=0;
        // whether we have detected at least a digit
        int flag_digit=0;
        for (int i=0; i<s.length(); i++)
        {
            // skip the space at the head
            if (s.charAt(i)==' ')
            {
                flag_space++;
            }
            else
            {
                if(s.charAt(i)=='+' || s.charAt(i)=='-')
                {
                    if(flag_sign==0)
                    {
                        flag_sign++;
                    }
                    else
                    {
                        return false;
                    }
                }
                else
                {
                    flag_sign++;
                    if (s.charAt(i)=='e' || s.charAt(i)=='E')
                    {
                        if(flag_e==0)
                        {
                            flag_e++;
                        }
                        else
                        {
                            return false;
                        }
                    }
                    else
                    {
                        if (s.charAt(i)=='.')
                        {
                            if (flag_dot==0)
                            {
                                flag_dot++;
                            }
                            else
                            {
                                return false;
                            }
                        }
                        else
                        {
                            if (s.charAt(i)<'0' || s.charAt(i)>'9')
                            {
                                return false;
                            }
                            else
                            {
                            	if (flag_space>0 && flag_digit>0)
                            	{
                            		// if we have met a digit and space after the digit, then we met a digit again
                            		// we should fail this case
                            		return false;
                            	}
                            	else if (flag_space>0)
                            	{
                            		// we met the first digit after the space
                            		// set the flag for space after digit as false
                            		flag_space=0;
                            		flag_digit++;
                            	}
                            	// ordinary case
                            	// we met the digit before but not space after the digit
                                flag_digit++;
                            }
                        }
                    }
                }
            }
        }
        return flag_digit==0;
    }
}
