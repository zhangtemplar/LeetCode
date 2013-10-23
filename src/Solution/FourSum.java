public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we use the simple algorithm which has complexity o(n^3 log(n))
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        if (num==null || num.length<4)
        {
            return new ArrayList<ArrayList<Integer>>(result);
        }
        // sort
        Arrays.sort(num);
        for (int i=0; i<num.length; i++)
        {
            for (int j=num.length-1; j>=i+3; j--)
            {
                int p=i+1;
                int q=j-1;
                int sum=target-num[i]-num[j];
                while(p<q)
                {
                    int residule=sum-num[p]-num[q];
                    // we found a solution
                    if (residule==0)
                    {
                        ArrayList<Integer> entry=new ArrayList<Integer>();
                        entry.add(num[i]);
                        entry.add(num[p]);
                        entry.add(num[q]);
                        entry.add(num[j]);
                        result.add(entry);
                        p++;
                        q--;
                    }
                    // current combination is too small
                    else if(residule>0)
                    {
                        p++;
                    }
                    // current combination is too large
                    else
                    {
                        q--;
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}
