public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // the algorithm is that, we use an array of size 32
        // where each entry stores the # of occurences of number have bit i==1
        // we pick any number which is not 3
        if (A==null || A.length<1)
        {
            return 0;
        }
        int []table=new int[32];
        for (int i=0; i<A.length; i++)
        {
            for (int j=0; j<32; j++)
            {
                table[j]+=(A[i]>>>j) & 1;
            }
        }
        // find any number which is not mulitiplier of 3
        int result=0;
        for (int j=0; j<32; j++)
        {
            if (table[j]%3!=0)
            {
                result|=(1<<j);
            }
        }
        return result;
    }
}
