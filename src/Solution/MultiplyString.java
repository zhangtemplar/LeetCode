public class Solution {
    public String multiply(String num1, String num2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (num1==null || num1.length()<1 || num2==null || num2.length()<1)
        {
            return new String("0");
        }
        // make sure num1 is shorter than num2
        else if(num1.length()>num2.length())
        {
            return multiply(num2, num1); 
        }
        // apply the multiplication
        ArrayList<Integer> result=new ArrayList<Integer>();
        for (int i=num1.length()-1; i>=0; i--)
        {
            // make the multiplication
            int increment=0;
            int sum=0;
            ArrayList<Integer> buffer=new ArrayList<Integer>();
            for (int j=num2.length()-1; j>=0; j--)
            {
                sum=(num1.charAt(i)-'0')*(num2.charAt(j)-'0')+increment;
                buffer.add(sum%10);
                increment=sum/10;
            }
            if (increment>0)
            {
                buffer.add(increment);
                increment=0;
            }
            // combine with the previous result
            if (i==num1.length()-1)
            {
                result.addAll(buffer);
            }
            else
            {
                for (int l=0; l<buffer.size(); l++)
                {
                    if (result.size()<l+num1.length()-i)
                    {
                        sum=buffer.get(l)+increment;
                        result.add(sum%10);
                        increment=sum/10;
                    }
                    else
                    {
                        sum=result.get(l+num1.length()-i-1)+buffer.get(l)+increment;
                        result.set(l+num1.length()-i-1, sum%10);
                        increment=sum/10;
                    }
                }
                if (increment>0)
                {
                    if (result.size()<buffer.size()+num1.length()-i)
                    {
                        result.add(increment);
                    }
                    else
                    {
                        result.set(buffer.size()+num1.length()-i-1, increment);
                    }
                    increment=0;
                }
            }
        }
        // convert to the string
        StringBuffer str=new StringBuffer();
        boolean head0=true;
        for(int i=result.size()-1; i>=0; i--)
        {
            if (!head0 || result.get(i)!=0)
            {
                str.append(result.get(i));
                head0=false;
            }
        }
        if (str.length()<1)
        {
        	return "0";
        }
        else
        {
        	return str.toString();
    	}
    }
}	
