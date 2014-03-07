package trial3;
import java.util.HashMap;


public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []num={1,0,-1};
		System.out.println(new LongestConsecutiveSequence().longestConsecutive(num));
	}
	/**
     * a navie solution is to sort the sequence, and such sequence can be easily found
     * however sorting takes nlogn complexity
     */
    public int longestConsecutive(int[] num) {
        if (num==null || num.length<1)
        {
            return 0;
        }
        // these two hashmap stores the location of the next smaller/larger number of the key
        HashMap<Integer, Boolean> prev=new HashMap<Integer, Boolean>();
        HashMap<Integer, Boolean> next=new HashMap<Integer, Boolean>();
        
        for (int i=0; i<num.length; i++)
        {
            // so we have sequence like num[i]-1 > num[i]
            if (prev.containsKey(num[i]-1))
            {
                prev.put(num[i], true);
            }
            else
            {
                prev.put(num[i], false);
            }
            if (prev.containsKey(num[i]+1))
            {
                prev.put(num[i]+1, true);
            }
            // so we have sequence like num[i] > num[i]+1
            if (next.containsKey(num[i]+1))
            {
                next.put(num[i], true);
            }
            else
            {
                next.put(num[i], false);
            }
            if (next.containsKey(num[i]-1))
            {
                next.put(num[i]-1, true);
            }
        }
        
        // find the longest consecutive sequence
        int result=1;
        for(int x: num)
        {
            int i=x;
            int j=x;
            int len=1;
            while(true)
            {
                if (prev.get(i).equals(true))
                {
                    prev.put(i, false);
                    i--;
                    len++;
                }
                else
                {
                    break;
                }
            }
            while(true)
            {
                if (next.get(j).equals(true))
                {
                    next.put(j, false);
                    j++;
                    len++;
                }
                else
                {
                    break;
                }
            }
            if (len>result)
            {
                result=len;
            }
        }
        return result;
    }
}
