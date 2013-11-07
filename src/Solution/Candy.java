public class Solution {
    public int candy(int[] ratings) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (ratings==null || ratings.length<1)
        {
            return 0;
        }
        else if (ratings.length==1)
        {
            return 1;
        }
        // left[i] records how many adajacent elements on the left of i is larger
        int []left=new int[ratings.length];
        for (int i=1; i<left.length; i++)
        {
            if (ratings[i]>ratings[i-1])
            {
                left[i]=left[i-1]+1;
            }
        }
        int []right=new int [ratings.length];
        for (int i=right.length-2; i>=0; i--)
        {
            if (ratings[i]>ratings[i+1])
            {
                right[i]=right[i+1]+1;
            }
        }
        // we use this information to decide how many candies to distribute
        // candy[i]=max(left[i], right[i]);
        int min=0;
        for (int i=0; i<ratings.length; i++)
        {
            min+=Math.max(left[i], right[i])+1;
        }
        return min;
    }
}
