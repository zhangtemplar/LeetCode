package Solution;

public class CountSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we can use recursion
        if (n<=0)
        {
            return new String("");
        }
        else if (n==1)
        {
            return new String("1");
        }
        else
        {
            String base=countAndSay(n-1);
            StringBuffer result=new StringBuffer();
            int i=1;
            char previous=base.charAt(0);
            int count=1;
            while(i<base.length())
            {
                if (base.charAt(i)==previous)
                {
                    count++;
                    i++;
                }
                else
                {
                    result.append(count);
                    result.append(previous);
                    count=1;
                    previous=base.charAt(i);
                    i++;
                }
            }
            // check the end
            result.append(count);
            result.append(previous);
            return result.toString();
        }
    }
}
