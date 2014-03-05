package trial3;

import java.util.ArrayList;

public class Candy {
	public static void main(String[] args)
	{
		int []ratings={370,28,37,15,379,458,342,346,328,257,81,400,426,461,349,362,315,410,427,458,264,322,326,350,369,383,184,343,402,274,184,124,154,73,491,33,31,333,379,212,91,313,112,369,274,461,83,441,223,362,399,339,185,77,189,406,312,373,249,66,147,433,191,153,358,182,187,242,368,418,454,311,231,418,180,358,379,115,151,454,478,403,293,163,480,482,69,145,207,318,63,207,103,254,360,313,289,399,55,9,318,361,320,401,279,352,111,10,319,263,464,297,18,109,460,350,91,381,495,151,51,59,358,6,165,218,320,306,118,375,315,288,89,487,41,368,191,5,379,11,120,195,308,138,305,121,488,248,2,336,399,406,395,257,412,412,328,232,71,446,460,238,86,49,226,127,417,269,132,148,280,104,344,441,242,1,414,231,101,416,419,1,174,314,110,87,78,438,319,149,236,279,388,322,328,466,302,98,235,286,246,368,391,442,161,133,295,75,216,397,343,135,250,18,301,360,105,232,299,424,381,35,56,121,210,384,439,12,482,175,298,81,395,41,23,408,175,171,483,243,68,178,231,318,48,32,178,153,116,329,430,498,217,338,471,279,222,411,291,57,438,441,490,185,483,365,93,10,36,428,105,104,106,336,274,155,221,305,160,337,134,442,335,203,280,159,482,355,70,125,412,360,67,254,45,402,119,138,412,156,66,17,112,24,206,387,179,427,192,192,264,178,134,452,382,415,111,216,270,33,342,34,393,261,288,290,163,407,428,427,63,346,444,176,370,2,415,402,429,107,94,194,285,80,146,19,495,109,236,117,494,78,151,387,191,439,29,354,199,457,281,114,155,77,290,25,80,57,279,361,164,225,55,302,306,53,321,153,14,57,271,8,487,422,247,178,214,276,384,413,233,17,27,240,95,170,118,27,227,397,388,244,475,296,46,281,201,367,434,216,277,57,224,264,332,472,295,398,248,179,311,334,197,190,74,144,212,192,23,292,442,263,388,417,411,434,50,113,153,336,329,430,394,53,47,226,377,194,124,126,225,287,312,274,329,238,418,394,283,293,186,225,409,426,494,320,360,44,433,365,380,262,148,126,316,47,204,45,241,180,23,466,467,335,241,149,426,11,43,209,157,81,286,66,7,280,386,219,176,320};
		int []assignment=new int[ratings.length];
		// solution is 1050
		System.out.println(new Candy().candy(ratings, assignment));
		int sum=0;
		
		for (int i=0; i<assignment.length; i++)
		{
			System.out.print(ratings[i]);
			System.out.print("\t");
		}
		System.out.println();
		for (int i=0; i<assignment.length; i++)
		{
			System.out.print(assignment[i]);
			sum+=assignment[i];
			System.out.print("\t");
		}
		System.out.println();
		System.out.println(sum);
		
		for (int i=1; i<assignment.length; i++)
		{
			if (ratings[i]>ratings[i-1] && assignment[i]<assignment[i-1])
			{
				System.out.println(i);
			}
			
			if (ratings[i]<ratings[i-1] && assignment[i]>assignment[i-1])
			{
				System.out.println(i);
			}
		}
	}
	
	/**
     * the problem can be broken into the following steps:
     *  1) break the array into set of increasing subsequences
     *  2) for each such subsequence, we assign score like 1: ni
     *  3) compute the total score
     * however, this process only gaurrantee requirement from left to right
     * so we need to scan again from right to left
     */
    public int candy(int[] ratings) {
        if (ratings==null || ratings.length<1)
        {
            return 0;
        }
        if (ratings.length==1)
        {
            return 1;
        }
        // this stores the beginning and end of the increasing subsequence
        ArrayList<Integer> left=new ArrayList<Integer>();
        ArrayList<Integer> right=new ArrayList<Integer>();
        
        // find the set of increasing subsequences
        left.add(0);
        for (int i=1; i<ratings.length; i++)
        {
            // violated of increasing, create a new subsequence
            if (ratings[i]<=ratings[i-1])
            {
                right.add(i-1);
                left.add(i);
            }
        }
        right.add(ratings.length-1);
        
        // scan from right to left
        int prev=1;
        // for the last subsequence
        long len=(long) right.get(right.size()-1)-left.get(right.size()-1);
        int result=(int)((len+2)*(len+1)/2);
        for (int i=left.size()-2; i>=0; i--)
        {
            // for the current subsequence, try to assign as 1, 2, ..., ni
            len=(long) right.get(i)-left.get(i);
            result+=(int)((len+2)*(len+1)/2);
            // however ni dosen't satify the condition, thus we increase ni to prev+1
            if (right.get(i)-left.get(i)<prev && ratings[right.get(i)]>ratings[right.get(i)+1])
            {
                result+=prev-right.get(i)+left.get(i);
            }
            // if the subsequence is singleton, we need to increase prev
            if (right.get(i)==left.get(i) && ratings[right.get(i)]>ratings[right.get(i)+1])
            {
                prev++;
            }
            else
            {
                prev=1;
            }
        }
        return result;
    }
    
    /**
     * the problem can be broken into the following steps:
     *  1) break the array into set of increasing subsequences
     *  2) for each such subsequence, we assign score like 1: ni
     *  3) compute the total score
     * however, this process only gaurrantee requirement from left to right
     * so we need to scan again from right to left
     */
    public int candy(int[] ratings, int []assignment) {
        if (ratings==null || ratings.length<1 || assignment.length!=ratings.length)
        {
            return 0;
        }
        if (ratings.length==1)
        {
            return 1;
        }
        // this stores the beginning and end of the increasing subsequence
        ArrayList<Integer> left=new ArrayList<Integer>();
        ArrayList<Integer> right=new ArrayList<Integer>();
        
        // find the set of increasing subsequences
        left.add(0);
        for (int i=1; i<ratings.length; i++)
        {
            // violated of increasing, create a new subsequence
            if (ratings[i]<=ratings[i-1])
            {
                right.add(i-1);
                left.add(i);
            }
        }
        right.add(ratings.length-1);
        
        // scan from right to left
        int prev=1;
        // for the last subsequence
        long len=(long) right.get(right.size()-1)-left.get(right.size()-1);
        int result=(int)((len+2)*(len+1)/2);
        int k=1;
        for (int i=left.get(right.size()-1); i<=right.get(right.size()-1); i++)
        {
        	assignment[i]=k;
        	k++;
        }
        for (int i=left.size()-2; i>=0; i--)
        {
            // for the current subsequence, try to assign as 1, 2, ..., ni
        	k=1;
        	for (int j=left.get(i); j<=right.get(i); j++)
        	{
        		assignment[j]=k;
        		k++;
        	}
            len=(long) right.get(i)-left.get(i);
            result+=(int)((len+2)*(len+1)/2);
            // however ni dosen't satify the condition, thus we increase ni to prev+1
            if (right.get(i)-left.get(i)<prev && ratings[right.get(i)]>ratings[right.get(i)+1])
            {
                result+=prev-right.get(i)+left.get(i);
                assignment[right.get(i)]=prev+1;
            }
            // if the subsequence is singleton, we need to increase prev
            if (right.get(i)==left.get(i) && ratings[right.get(i)]>ratings[right.get(i)+1])
            {
                prev++;
            }
            else
            {
                prev=1;
            }
        }
        return result;
    }
}
