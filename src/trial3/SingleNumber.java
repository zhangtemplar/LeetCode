package trial3;

public class SingleNumber {
	/**
     * this number can be found by xor, where xor on a number twice will be 0
     */
    public int singleNumber(int[] A) {
        int result=0;
        if (A==null || A.length<1)
        {
            return result;
        }
        for (int i=0; i<A.length; i++)
        {
            result=result^A[i];
        }
        return result;
    }
}
