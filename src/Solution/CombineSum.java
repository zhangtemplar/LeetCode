public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (candidates==null || candidates.length<1)
        {
            return new ArrayList<ArrayList<Integer>>();
        }
        // sort the data
        Arrays.sort(candidates);
        int[] unique=findUnique(candidates);
        buffer=new HashMap<Integer, ArrayList<ArrayList<Integer>>>();
        // pick the unqiue data
        // we will use backtrace
        // at each step, if the sum of the currently selected element is smaller than the target
        // we will have two choices: we either pick the last selected element again
        // or we pick a new element
        return combinationSum(unique, 0, target);
    }
    
    private HashMap<Integer, ArrayList<ArrayList<Integer>>> buffer=null;
    
    // this function find the unique element
    private int [] findUnique(int[] candidates)
    {
        int available=1;
        for (int i=1; i<candidates.length; i++)
        {
            if (candidates[i]!=candidates[i-1])
            {
                candidates[available++]=candidates[i];
            }
        }
        return Arrays.copyOf(candidates, available);
    }
    
    // find the subset whose sum is equal to remain. You are only allowed to use element after or right the current
    private ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int current, int remain)
    {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>();
        if(remain==0)
        {
            result.add(new ArrayList<Integer>());
        }
        // build the solution from the base case
        else if(remain>0)
        {
            // try each possible location from the last choice
            for (int i=current; i<candidates.length; i++)
            {
                // find a valid choice
                if (candidates[i]<=remain)
                {
                    // for the valid choice, we add the selection
                    ArrayList<ArrayList<Integer>> base=combinationSum(candidates, i, remain-candidates[i]);
                    // if there is no valid choice, the base will be empty
                    for (ArrayList<Integer> entry: base)
                    {
                        ArrayList<Integer> element=new ArrayList<Integer>();
                        element.add(candidates[i]);
                        element.addAll(entry);
                        result.add(element);
                    }
                }
            }
        }
        return result;
    }
}
