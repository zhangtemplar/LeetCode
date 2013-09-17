package Solution;

import java.util.Random;

public class IntergerRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random seed=new Random();
		int x;
		String str;
		for (int i=0; i<100; i++)
		{
			x=seed.nextInt(3999);
			str=intToRoman(x);
			System.out.println(x+" "+str+" "+romanToInt(str));
		}
	}

	public static String intToRoman(int num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sign=1;
        if (num<0)
        {
            sign=-1;
        }
        StringBuffer str=new StringBuffer();
        int x;
        int y;
        y=0;
        while(num>0)
        {
            x=num%10;
            num=num/10;
            str.insert(0, String_Pattern[y][x]);
            y++;
        }
        if (sign<0)
        {
            str.insert(0, '-');
        }
        return str.toString();
    }
    // some constants
    private static final String [][]String_Pattern={
        {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
        {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
        {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
        {"", "M", "MM", "MMM"}};
    
    public static int romanToInt(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int result=0;
        int i=0;
        int flag=1;
        boolean skip=false;
        while (i<s.length())
        {
            // in case of sign
            if (s.charAt(i)=='-')
            {
                flag=-1;
                i++;
                continue;
            }
            if (i<s.length()-1)
            {
            	// 4
            	if (String_Order[s.charAt(i)]+1==String_Order[s.charAt(i+1)])
            	{
            		result=result+4*String_Value[s.charAt(i)];
            		i++;
            	}
            	else if (String_Order[s.charAt(i)]+2==String_Order[s.charAt(i+1)])
            	{
            		result=result+9*String_Value[s.charAt(i)];
            		i++;
            	}
            	else
            	{
            		result=result+String_Value[s.charAt(i)];
            	}
            }
            else
            {
        		result=result+String_Value[s.charAt(i)];
            }
            i++;
        }
        return flag*result;
    }
    
    private static final int[] String_Order={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    0,0,0,5,6,0,0,0,0,1,0,0,4,7,0,0,0,0,0,0,0,0,2,0,3,0,0,0,0,0,0,0,
    0,0,0,5,6,0,0,0,0,1,0,0,4,7,0,0,0,0,0,0,0,0,2,0,3,0,0,0,0,0,0,0};
    
    private static final int[] String_Value={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
        0,0,0,100,500,0,0,0,0,1,0,0,50,1000,0,0,0,0,0,0,0,0,5,0,10,0,0,0,0,0,0,0,
        0,0,0,100,500,0,0,0,0,1,0,0,50,1000,0,0,0,0,0,0,0,0,5,0,10,0,0,0,0,0,0,0};
}
