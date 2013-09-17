package Solution;

import java.util.ArrayList;

public class MultiplyString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyString instance=new MultiplyString();
		System.out.println(instance.multiply("0", "0"));
	}

	public String multiply(String num1, String num2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we first convert the input to an array list of integer
        if (num1==null || num1.length()<1 || num2==null || num2.length()<1)
        {
            return new String();
        }
        // the most significant bit is put at the head
        ArrayList<Integer> z=new ArrayList<Integer>();
        // we start from the most siginificant digit
        for (int i=0; i<num1.length(); i++)
        {
            // shift the digit up by 1 digits
            z.add(0);
            for (int j=0; j<num2.length(); j++)
            {
                if(z.size()<=i+j)
                {
                    z.add((num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
                }
                else
                {
                    z.set(i+j, z.get(i+j)+(num1.charAt(i)-'0')*(num2.charAt(j)-'0'));
                }
            }
        }
        // post-processing: make every entry to be a single digits
        int increment=0;
        StringBuffer result=new StringBuffer();
        for (int i=z.size()-1; i>=0; i--)
        {
            // we keep the last digit and shift the remaining to the digits up
            increment+=z.get(i);
            result.insert(0, increment%10);
            increment=increment/10;
        }
        // for the last digits
        if (increment>0)
        {
            result.insert(0, increment);
        }
        // remove the 0 at the begining
        int i=0;
        for (i=0; i<result.length(); i++)
        {
            if (result.charAt(i)!='0')
            {
                break;
            }
        }
        if (i>=result.length())
        {
            // just return '0'
            return result.substring(0, 1);
        }
        else
        {
            return result.substring(i, result.length());
        }
    }
    
    private ArrayList<Integer> string2Array(String num)
    {
        ArrayList<Integer> arr=new ArrayList<Integer>();
        for (int i=0; i<num.length(); i++)
        {
            arr.add(num.charAt(i)-'0');
        }
        return arr;
    }
}
