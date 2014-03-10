package trial3;

import java.util.ArrayList;

public class GrayCode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * say g(n) is the sequence
     * then g(n)=g(n-1),reverse(g(n-1))+2^(n-1)
     */
    public ArrayList<Integer> grayCode(int n) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(n+1);
        ArrayList<Integer> level=new ArrayList<Integer>();
        // 0
        level.add(0);
        result.add(level);
        if (n<1)
        {
            return level;
        }
        // 1
        for(int i=1; i<=n; i++)
        {
            level=new ArrayList<Integer>(result.get(i-1));
            int base=1<<(i-1);
            for (int j=result.get(i-1).size()-1; j>=0; j--)
            {
                level.add(result.get(i-1).get(j)+base);
            }
            result.add(level);
        }
        return result.get(n);
    }
}
