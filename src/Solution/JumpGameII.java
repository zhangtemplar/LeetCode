package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGameII instance=new JumpGameII();
		ArrayList<Integer> arr=new ArrayList<Integer>();
		StringTokenizer token=new StringTokenizer(args[0]);
		while(token.hasMoreTokens())
		{
			arr.add(Integer.parseInt(token.nextToken()));
		}
		int []num=new int[arr.size()];
		for (int i=0; i<arr.size(); i++)
		{
			num[i]=arr.get(i);
		}
		System.out.println(instance.jump(num));
	}
	
	public int jump(int []A)
	{
		int ret = 0;
        int last = 0;
        int curr = 0;
        for (int i = 0; i < A.length; ++i) {
            if (i > last) {
                last = curr;
                ++ret;
            }
            curr = curr>(i+A[i])?curr:(i+A[i]);
        }

        return ret;
	}

	public int jumpSlow(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
		// we use dynamic programming to solve this problem
		// it seems to be very slow
        if (A==null || A.length<1)
        {
            return 0;
        }
        buffer=new int[A.length];
        Arrays.fill(buffer, -1);
        return jump(A, 0);
    }
    
    // the buffer
    private int[] buffer;
    
    // the minimum number of steps takes from i to the end
    private int jump(int []A, int i)
    {
        // check the buffer first
        if (i>=A.length-1)
        {
            // we already get here
            return 0;
        }
        else if(buffer[i]>=0)
        {
            return buffer[i];
        }
        else
        {
            int min=Integer.MAX_VALUE/2;
            int trial=0;
            // we try from the start
            for (int j=A[i]; j>0; j--)
            {
                trial=jump(A, i+j);
                if (trial<min)
                {
                    min=trial;
                }
                // we meet the target there is no need to try any more
                if (min==0)
                {
                    break;
                }
            }
            buffer[i]=min+1;
            return min+1;
        }
    }
}
