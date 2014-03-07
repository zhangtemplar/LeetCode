package trial3;

import java.util.Arrays;

public class Candy {
	public int candy(int[] ratings) {
        if (ratings==null || ratings.length<1)
        {
            return 0;
        }
        else if (ratings.length==1)
        {
            return 1;
        }
        int []left=new int[ratings.length];
        Arrays.fill(left, 1);
        
        for (int i=1; i<ratings.length; i++)
        {
            if (ratings[i]>ratings[i-1])
            {
                left[i]=left[i-1]+1;
            }
        }
        
        int []right=new int[ratings.length];
        Arrays.fill(right, 1);
        
        for (int i=ratings.length-2; i>=0; i--)
        {
            if (ratings[i]>ratings[i+1])
            {
                right[i]=right[i+1]+1;
            }
        }
        
        int result=0;
        for (int i=0; i<ratings.length; i++)
        {
            result+=Math.max(left[i], right[i]);
        }
        return result;
    }
}
