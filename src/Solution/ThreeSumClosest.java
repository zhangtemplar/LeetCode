package Solution;

import java.util.Arrays;

public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []arr={87,6,-100,-19,10,-8,-58,56,14,-1,-42,-45,-17,10,20,-4,13,-17,0,11,-44,65,74,-48,30,-91,13,-53,76,-69,-19,-69,16,78,-56,27,41,67,-79,-2,30,-13,-60,39,95,64,-12,45,-52,45,-44,73,97,100,-19,-16,-26,58,-61,53,70,1,-83,11,-35,-7,61,30,17,98,29,52,75,-73,-73,-23,-75,91,3,-57,91,50,42,74,-7,62,17,-91,55,94,-21,-36,73,19,-61,-82,73,1,-10,-40,11,54,-81,20,40,-29,96,89,57,10,-16,-34,-56,69,76,49,76,82,80,58,-47,12,17,77,-75,-24,11,-45,60,65,55,-89,49,-19,4};
		System.out.println(threeSumClosest(arr, -275));
	}

	/**
     * the idea is similar to 3sum problem, however, with the following differences
     * if k>0, this means we have find an exact solution, so return it;
     * otherwise, check the sum with s[-1-k] and s[-2-k] and keep the smaller one
     */
    public static int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int sum=Integer.MAX_VALUE;
        if (num==null || num.length<3)
        {
			return sum;
		}
		Arrays.sort(num);
		for (int i=0; i<num.length-2; i++)
		{
			for (int j=i+1; j<num.length-1; j++)
			{
				int k=Arrays.binarySearch(num, j+1, num.length, target-num[i]-num[j]);
				// since we start from the left, we should have already consider the triple with numbers before j
				if (k>=0)
				{
					// we found an exact solution
					return 0;
				}
                // no exaxt solution found
                // an special case, which we only search for right hand
                else if (k==-2-j)
                {
                	if (k>=-num.length)
                	{
	                    int s1=Math.abs(target-num[-1-k]-num[i]-num[j]);
	                    if (Math.abs(target-sum)>s1)
	                    {
	                        sum=num[-1-k]+num[i]+num[j];
	                    }
                	}
                }
                // the other case
                else if (k<-num.length)
                {
                	int s2=Math.abs(target-num[-2-k]-num[i]-num[j]);
                    sum=num[-2-k]+num[i]+num[j];
                }
                else
                {
                    int s1=Math.abs(target-num[-1-k]-num[i]-num[j]);
                    int s2=Math.abs(target-num[-2-k]-num[i]-num[j]);
                    if (Math.abs(target-sum)>s1)
                    {
                        sum=num[-1-k]+num[i]+num[j];
                    }
                    if (Math.abs(target-sum)>s2)
                    {
                        sum=num[-2-k]+num[i]+num[j];
                    }
                }
			}
		}
		return sum;
    }
}
