public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // a naive solution has complexity of o(N^3)
        // however an improved version can be follows: 
        // 0) sort the input array, where the complexity is O(N logN)
        // 1) we compute the sum of each pair of data, which costs O(N^2)
        // 2) for each data x of the pairwise sum, use binary search for target-x in the original array, which costs O(logN) each and O(N^2logN) in total
        // the overall complexity is o(N^2log(N))
        // the result is either the returned result, or the result after that.
        // note another method could search in pairwise sum, however the sort of that array also costs O(N^2logN)
        // and the logic will be much more complex
        if (num==null || num.length<3)
        {
            return target;
        }
        // Step 0: sort the array
        Arrays.sort(num);
        // Step 1: pair-wise sum
        // we need to main a hashmap, to avoid the elements used twice
        int []pair_sum=new int[num.length*(num.length-1)/2];
        int [][]duplicate=new int[pair_sum.length][2];
        pairSum(num, pair_sum, duplicate);
        int sum=0;
        int min=Integer.MAX_VALUE;
        int tmp_sum=0;
        int tmp_min=Integer.MAX_VALUE;
        int []result=new int[2];
        // Step 2: find the optimal
        for (int i=0; i<pair_sum.length; i++)
        {
            int index=Arrays.binarySearch(num, target-pair_sum[i]);
            // note that, index can be negative, which means no exact search can be found
            if (index>0 && searchAround(num, index, target-pair_sum[i], duplicate[i], result))
            {
                tmp_sum=result[1]+pair_sum[i];
                tmp_min=Math.abs(target-tmp_sum);
                if (min>tmp_min)
                {
                    min=tmp_min;
                    sum=tmp_sum;
                }
            }
            else
            {
                // there is no exact match there
                // however, do know one thing: the optimal result must be obtained from -1-index or -2-index
            	if (searchAround(num, -1-index, target-pair_sum[i], duplicate[i], result))
            	{
	                tmp_sum=result[1]+pair_sum[i];
	                tmp_min=Math.abs(target-tmp_sum);
	                if (min>tmp_min)
	                {
	                    min=tmp_min;
	                    sum=tmp_sum;
	                }
            	}
            	if (searchAround(num, -2-index, target-pair_sum[i], duplicate[i],result))
            	{
                tmp_sum=result[1]+pair_sum[i];
                tmp_min=Math.abs(target-tmp_sum);
                if (min>tmp_min)
                {
                    min=tmp_min;
                    sum=tmp_sum;
                }
            	}
            }
        }
        return sum;
    }
    
    private boolean searchAround(int[] num, int index, int target, int []duplicate, int result[])
    {
    	boolean flag=false;
        int min=Integer.MAX_VALUE;
        int sum=Integer.MAX_VALUE;
        if (duplicate[1]!=index && duplicate[0]!=index && duplicate[1]!=index && index>=0 && index<num.length)
        {
            // we are lucky
        	flag=true;
        	int val=Math.abs(target-num[index]);
            if (min>val)
            {
                min=val;
                sum=num[index];
            }
        }
        // we need to look for the other data, luckily, it can only be index-1 or index+1
        // if we don't get duplicate again
        if (duplicate[1]!=index-1 && duplicate[0]!=index-1 && index>=1 && index-1<num.length)
        {
        	flag=true;
            int val=Math.abs(target-num[index-1]);
            if (min>val)
            {
                min=val;
                sum=num[index-1];
            }
        }
        if (duplicate[1]!=index+1 && duplicate[0]!=index+1 && index+1<num.length && index+1>=0)
        {
        	flag=true;
            int val=Math.abs(target-num[index+1]);
            if (min>val)
            {
                min=val;
                sum=num[index+1];
            }
        }
        // for safety, check index-2, index+2 also
        if (duplicate[1]!=index-2 && duplicate[0]!=index-2 && index>=2 && index-2<num.length)
        {
        	flag=true;
            int val=Math.abs(target-num[index-2]);
            if (min>val)
            {
                min=val;
                sum=num[index-2];
            }
        }
        if (duplicate[1]!=index+2 && duplicate[0]!=index+2 && index+2<num.length && index+2>=0)
        {
        	flag=true;
            int val=Math.abs(target-num[index+2]);
            if (min>val)
            {
                min=val;
                sum=num[index+2];
            }
        }
        result[0]=min;
        result[1]=sum;
        return flag;
    }
    
    private void pairSum(int []num, int []result, int[][] duplicate)
    {
        int k=0;
        for (int i=0; i<num.length; i++)
        {
            for (int j=i+1; j<num.length; j++)
            {
                // add in the utilization information
                duplicate[k][0]=i;
                duplicate[k][1]=j;
                result[k++]=num[i]+num[j];
            }
        }
    }
}
