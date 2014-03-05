package trial3;

public class GasStation {
	public static void main(String[] args)
	{
		int []gas={2, 4};
		int []cost={3, 4};
		System.out.println(new GasStation().canCompleteCircuit(gas, cost)); 
	}
	/**
     * we can travel if and only if for any j that \sum_{k=i}{j}{gas[i]-cost[i]}>0
     * i is the selected starting point, we can try it all possible i, however with o(n2) complexity
     * in fact, we can skip all the case from i to first failed j, and try j+1 first.
     * this will have linear complexity
     * 
     * to deal with circular, we make add a reversed copy of gas/cost to the original one
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null || cost==null || gas.length<1 || cost.length<1 || gas.length!=cost.length)
        {
            return -1;
        }
        if (gas.length==1)
        {
            if (gas[0]>=cost[0])
            {
                return 0;
            }
            else
            {
                return -1;
            }
        }
        int i=0;
        int j=0;
        int remain=0;
        while(i<gas.length)
        {
            j=i;
            remain=0;
            while(true)
            {
                remain+=gas[j]-cost[j];
                if (remain<0)
                {
                    break;
                }
                j=(j+1)%gas.length;
                // a cycle made
                if (i==j)
                {
                    return i;
                }
            }
            if (i>j)
            {
            	break;
            }
            i=j+1;
        }
        return -1;
    }
}
