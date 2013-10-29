public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (gas==null || cost==null || gas.length!=cost.length)
        {
            return -1;
        }
        // this buffer stores the remaining gas at each station
        LinkedList<Integer> buffer=new LinkedList<Integer>();
        int start=0;
        while(start<gas.length)
        {
            int next=subCanCompleteCircuit(gas, cost, start);
            if (next>=0)
            {
                return next;
            }
            // we have already tried this before
            else if (start>=-next)
            {
                return -1;
            }
            else
            {
                start=-next;
            }
        }
        return -1;
    }
    
    private int subCanCompleteCircuit(int []gas, int []cost, int start)
    {
        int remain=0;
        boolean flag=true;
        for(int j=start; flag || j!=start; j=(j+1)%gas.length)
        {
            flag=false;
            remain=remain+gas[j]-cost[j];
            // we find an error
            // we try to restart from the next position
            if (remain<0)
            {
                return -j-1;
            }
        }
        return start;
    }
}
