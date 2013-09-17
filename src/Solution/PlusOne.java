package Solution;

import java.util.Arrays;

public class PlusOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []result;
        if (digits==null || digits.length<1)
        {
            result=new int[1];
            result[0]=1;
            return result;
        }
        if (digits[0]<0)
        {
            // for the sign
            result=minusOne(digits);
            result[0]=-result[0];
            return result;
        }
        else
        {
            // for the main
            int increment=1;
            for (int i=digits.length-1; i>=0; i--)
            {
                increment+=digits[i];
                digits[i]=increment%10;
                increment=increment/10;
            }
            if (increment>0)
            {
                // we have an extra bit
                // we need to remove the zeros at the beginning
                result=new int[digits.length+1];
                result[0]=increment;
                for (int j=1; j<result.length; j++)
                {
                    result[j]=digits[j-1];
                }
            }
            else
            {
                // we have an extra bit
                // we need to remove the zeros at the beginning
                int i;
                for (i=0; i<digits.length; i++)
                {
                    if (digits[i]>0)
                    {
                        break;
                    }
                }
                if (i>=digits.length)
                {
                    // the result is simply zero
                    result=new int[1];
                }
                else
                {
                    result=Arrays.copyOfRange(digits, i, digits.length);
                }
            }
            return result;
        }
    }
    
    private int[] minusOne(int[] digits)
    {
        // for the main
        int []result=null;
        int increment=-1;
        for (int i=digits.length-1; i>=0; i--)
        {
            if (digits[i]+increment<0)
            {
                digits[i]=10+increment;
            }
            else
            {
                digits[i]-=increment;
                increment=0;
            }
        }
        if (increment<0)
        {
            // the only possbility here is that, the number is too small
            // however this is impossible: to have this happen digits=0
            // but it will never be passed to here
        }
        else
        {
            // we have an extra bit
            // we need to remove the zeros at the beginning
            int i;
            for (i=0; i<digits.length; i++)
            {
                if (digits[i]>0)
                {
                    break;
                }
            }
            if (i>=digits.length)
            {
                // the result is simply zero
                result=new int[1];
            }
            else
            {
                result=Arrays.copyOfRange(digits, i, digits.length);
            }
        }
        return result;
    }
}
