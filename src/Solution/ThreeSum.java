public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // complexity o(n^2 log(n))
        if (num==null || num.length<3)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        // we first sort the array
        Arrays.sort(num);
        // we then compute the pairwise sum
        int k=(int)(((long)num.length)*(num.length-1))/2;
        int[] pair_sum=new int[k];
        int[][] pair_index=new int[k][2];
        k=0;
        for (int i=0; i<num.length; i++)
        {
            for (int j=i+1; j<num.length; j++)
            {
                pair_index[k][0]=i;
                pair_index[k][1]=j;
                pair_sum[k++]=num[i]+num[j];
            }
        }
        // search for the solution
        HashSet<ArrayList<Integer>> buffer=new HashSet<ArrayList<Integer>>();
        for(k=0; k<pair_sum.length; k++)
        {
            int idx=Arrays.binarySearch(num, -pair_sum[k]);
            // we found a solution
            if (idx>=0)
            {
                // check whether the number is used in the pair
                if (idx==pair_index[k][0] || idx==pair_index[k][1])
                {
                    // we find whether there is duplicate element there
                    // search forward
                    int i=idx-1;
                    while(i>=0 && num[i]==num[idx])
                    {
                        if (i==pair_index[k][0] || i==pair_index[k][1])
                        {
                            i--;
                        }
                        else
                        {
                            break;
                        }
                    }
                    // we found one
                    if (i>=0 && num[i]==num[idx] && i!=pair_index[k][0] && i!=pair_index[k][1])
                    {
                        buffer.add(createTriple(num[pair_index[k][0]], num[pair_index[k][1]], num[i]));
                        continue;
                    }
                    // we search backward
                    i=idx+1;
                    while(i<num.length && num[i]==num[idx])
                    {
                        if (i==pair_index[k][0] || i==pair_index[k][1])
                        {
                            i++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    // we found one
                    if (i<num.length && num[i]==num[idx] && i==pair_index[k][0] && i==pair_index[k][1])
                    {
                        buffer.add(createTriple(num[pair_index[k][0]], num[pair_index[k][1]], num[i]));
                    }
                }
                else
                {
                    buffer.add(createTriple(num[pair_index[k][0]], num[pair_index[k][1]], num[idx]));
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(buffer);
    }
    
    private ArrayList<Integer> createTriple(int x, int y, int z)
    {
        ArrayList<Integer> entry=new ArrayList<Integer>();
        if (z<x)
        {
            entry.add(z);
            entry.add(x);
            entry.add(y);
        }
        else if(z>y)
        {
            entry.add(x);
            entry.add(y);
            entry.add(z);
        }
        else
        {
            entry.add(x);
            entry.add(z);
            entry.add(y);
        }
        return entry;
    }
}
