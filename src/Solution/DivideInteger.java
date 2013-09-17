package Solution;

public class DivideInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DivideInteger instance=new DivideInteger();
		System.out.println(instance.divide(2147483647, 1));
	}

	public int divideSlow(int dividend, int divisor)
	{
		int sign=1;
		long dd=dividend;
		long ds=divisor;
		// for the sign
		if (dd<0)
		{
			sign=-sign;
			dd=-dd;
		}
		if (ds<0)
		{
			sign=-sign;
			ds=-ds;
		}
		// divide zero
		if (ds==0)
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
		long multiplier, result;
		multiplier=ds;
		result=0;
		while (multiplier<dd)
		{
			multiplier+=ds;
			result++;
		}
		return (int) (sign*result);
	}
	
	public int divide(int dividend, int divisor) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// we need to make sure there is no overflow
		long dd=dividend;
		long ds=divisor;
		// for the sign
        int sign=1;
		if (dd<0)
		{
			sign=-sign;
			dd=-dd;
		}
		if (ds<0)
		{
			sign=-sign;
			ds=-ds;
		}
		// divide zero
		if (ds==0)
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
        long sum, result, multiplier, step;
        sum=0;
        result=0;
        while(true)
        {
            multiplier=ds;
            step=1;
            // we double the guess (multiplier, step)
            // if dd=Integer.MAX_VALIE and sum or multiplier is int, this step will never terminate
            // so we need to make it as long
            while (sum+multiplier<=dd)
            {
                multiplier+=multiplier;
                step+=step;
            }
            multiplier=multiplier>>>1;
            step=step>>>1;
            // check the condition
            // this means we already found the solution
            if (step<=1)
            {
                break;
            }
            else
            {
                // otherwise, we put this in and found the next one
                sum+=multiplier;
                result+=step;
            }
        }
        return (int) (sign*(result+step));
    }
}
