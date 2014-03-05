package trial3;

public class SingleNumberII {
	/**
     * the idea is following, we use three counter
     * first counter for the bit set by multipliers of three
     * second counter for the bit set by once+multipliers of three
     * third for twice+multipliers of three
     * the result should be the second counter
     */
    public int singleNumber(int[] A) {
        int first, second, third;
        int first0, second0, third0;
        first=0;
        second=0;
        third=~0;
        if (A==null || A.length<1)
        {
            return first;
        }
        for (int i=0; i<A.length; i++)
        {
            first0=first;
            second0=second;
            third0=third;
            // the bit which set 3n before and also set in A[i] or the bit set 3n+1 before but not set in A[i]
            first=(first0 & ~A[i]) | (third0 & A[i]);
            second=(second0 & ~A[i]) | (first0 & A[i]);
            third=(third0 & ~A[i]) | (second0 & A[i]);
        }
        return first;
    }
}
