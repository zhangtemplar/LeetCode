public class Solution {
    public int singleNumber(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we will bit operation XOR
        // given the XOR on the same number will return 0
        // if we apply XOR on the array, all but the once appears only once will be canceled out
        if (A==null || A.length<1)
        {
            return 0;
        }
        int result=0;
        for (int i=0; i<A.length; i++)
        {
            result^=A[i];
        }
        return result;
    }
}
