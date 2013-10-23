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
            for (int j=i+1; j<num.length; j++)
            {
                for (int k=j+1; k<num.length; k++)
                {
                    int sum=target-num[i]-num[j]-num[k];
                    int l=Arrays.binarySearch(num, k+1, num.length, sum);
                    // we find a solution
                    if (l>=0)
                    {
                        ArrayList<Integer> entry=new ArrayList<Integer>();
                        entry.add(num[i]);
                        entry.add(num[j]);
                        entry.add(num[k]);
                        entry.add(num[l]);
                        result.add(entry);
                    }
                }
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}
