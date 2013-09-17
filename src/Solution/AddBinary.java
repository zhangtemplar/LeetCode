package Solution;

public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary instance=new AddBinary();
		System.out.println(instance.addBinary(new String("1"), new String("111")));
	}

	public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (a==null || a.length()<1)
        {
            return b;
        }
        else if (b==null || b.length()<1)
        {
            return a;
        }
        StringBuffer result=new StringBuffer();
        int increment=0;
        int i;
        for (i=0; i<a.length() && i<b.length(); i++)
        {
            int ai=a.charAt(a.length()-1-i)-'0';
            int bi=b.charAt(b.length()-1-i)-'0';
            result.insert(0, ai^bi^increment);
            increment=((ai & bi) | ((ai | bi) & increment));
        }
        // for the remaining bit
        if (i<a.length())
        {
            for (; i<a.length(); i++)
            {
                int ai=a.charAt(a.length()-1-i)-'0';
                result.insert(0, ai^increment);
                increment=(ai & increment);
            }
        }
        else if (i<b.length())
        {
            for (; i<b.length(); i++)
            {
                int bi=b.charAt(b.length()-1-i)-'0';
                result.insert(0, bi^increment);
                increment=(bi & increment);
            }
        }
        if (increment==1)
        {
            result.insert(0, increment);
        }
        return result.toString();
    }
}
