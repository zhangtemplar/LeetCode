package Solution;

import java.util.ArrayList;

public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayCode instance=new GrayCode();
		System.out.println(instance.grayCode(3));
	}

	public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use recursion
        // n=0: 0
        // n=1: 0 1
        // n=2: 0 1 (1 0)+2
        // n=3: 0 1 3 2 (2 0 1 3)+4
        ArrayList<Integer> result=new ArrayList<Integer>();
        // base case
        if (n<1)
        {
            result.add(0);
            return result;
        }
        else if (n==1)
        {
            result.add(0);
            result.add(1);
            return result;
        }
        else
        {
            ArrayList<Integer> base=grayCode(n-1);
            // there could be overflow for n>31
            int val=1<<(n-1);
            int i=0;
            // first part
            for (i=0; i<base.size(); i++)
            {
                result.add(base.get(i));
            }
            // second part
            i--;
            int j;
            for (j=0; j<base.size(); j++)
            {
                result.add(val+base.get((i-j)%base.size()));
            }
            return result;
        }
    }
}
