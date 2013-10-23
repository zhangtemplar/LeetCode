public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        // empty case
        if (num==null || num.length<1)
        {
            return result;
        }
        // sort the array
        Arrays.sort(num);
        ArrayList<Integer> entry=new ArrayList<Integer>();
        return combinationSum2(num, -1, target, entry);
    }
    
    /**
     * @param num the array
     * @param current the start of the array
     * @param target the current sum we want to achieve
     * @param base the current subset of the combination
     * @return the result
     */
    private ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int current, int target, ArrayList<Integer> base)
    {
        HashSet<ArrayList<Integer>> result=new HashSet<ArrayList<Integer>>();
        // a result is obtained
        if (target==0)
        {
            result.add(base);
        }
        // we use out all possibilites
        else if (current>=num.length-1)
        {
            if (target==0)
            {
                result.add(base);
            }
        }
        // we can try the next ones
        else
        {
            // we simply try all the element
            for (int i=current+1; i<num.length; i++)
            {
                // num would be positive
                if (target<num[i])
                {
                    continue;
                }
                ArrayList<Integer> entry=new ArrayList<Integer>(base);
                entry.add(num[i]);
                result.addAll(combinationSum2(num, i, target-num[i], entry));
            }
        }
        return new ArrayList<ArrayList<Integer>>(result);
    }
}
