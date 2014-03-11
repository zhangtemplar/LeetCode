package trial3;

import java.util.Stack;

public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char [][]matrix={
				{'0','0','0','1','0','1','1','1'},
				{'0','1','1','0','0','1','0','1'},
				{'1','0','1','1','1','1','0','1'},
				{'0','0','0','1','0','0','0','0'},
				{'0','0','1','0','0','0','1','0'},
				{'1','1','1','0','0','1','1','1'},
				{'1','0','0','1','1','0','0','1'},
				{'0','1','0','0','1','1','0','0'},
				{'1','0','0','1','0','0','0','0'}};
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}
	/**
     * this problem can be solved by using max under histogram area
     * assume h[i][j] is the height of continues 1s in Column j before i
     * obviously h[i][j]=h[i-1][j]+1, if matrix[i][j]=1 otherwise 0
     * complexity is o(N2)
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return 0;
        }
        // compute the histogram
        int [][]histogram=new int[matrix.length][matrix[0].length];
        for (int j=0; j<matrix[0].length; j++)
        {
            histogram[0][j]=matrix[0][j]=='1'?1:0;
        }
        for (int i=1; i<matrix.length; i++)
        {
            for (int j=0; j<matrix[0].length; j++)
            {
                histogram[i][j]=matrix[i][j]=='1'?histogram[i-1][j]+1:0;
            }
        }
        int result=0;
        // apply the max under histogram area
        for (int i=0; i<matrix.length; i++)
        {
            int []left=lastLeft(histogram[i]);
            int []right=firstRight(histogram[i]);
            for (int j=0; j<matrix[i].length; j++)
            {
                int area=histogram[i][j]*(right[j]-left[j]-1);
                if (area>result)
                {
                    result=area;
                }
            }
        }
        return result;
    }
    
    /**
     * find the largest index whose value is smaller than the one on current index on the left
     */
    private int []lastLeft(int []x)
    {
        int []result=new int[x.length];
        Stack<Integer> stack=new Stack<Integer>();
        result[0]=0;
        stack.push(0);
        for (int i=1; i<x.length; i++)
        {
            // easier case, it previous is lower
            if (x[i]>x[i-1])
            {
                result[i]=i-1;
            }
            // otherwise we need to search for a lower one on the left
            else
            {
                while(!stack.isEmpty())
                {
                    // we find such a position
                    if (x[i]>x[stack.peek()])
                    {
                        break;
                    }
                    stack.pop();
                }
                if (stack.isEmpty())
                {
                    result[i]=0;
                }
                else
                {
                    result[i]=stack.peek();
                }
            }
            stack.push(i);
        }
        // we need to fix the result whose value is 0
        // because it can be referring to 0 or inifinite
        for (int i=0; i<x.length; i++)
        {
            if (result[i]==0 && x[i]<=x[0])
            {
                result[i]=-1;
            }
        }
        return result;
    }
    
    /**
     * find the smallest index whose value is smaller than the one on current index on the right
     */
    private int[]firstRight(int []x)
    {
        int []result=new int[x.length];
        Stack<Integer> stack=new Stack<Integer>();
        result[x.length-1]=x.length-1;
        stack.push(x.length-1);
        for (int i=x.length-2; i>=0; i--)
        {
            // easier case, it previous is lower
            if (x[i]>x[i+1])
            {
                result[i]=i+1;
            }
            // otherwise we need to search for a lower one on the left
            else
            {
                while(!stack.isEmpty())
                {
                    // we find such a position
                    if (x[i]>x[stack.peek()])
                    {
                        break;
                    }
                    stack.pop();
                }
                if (stack.isEmpty())
                {
                    result[i]=x.length-1;
                }
                else
                {
                    result[i]=stack.pop();
                }
            }
            stack.push(i);
        }
        // we need to fix the result whose value is n-1
        for (int i=0; i<x.length; i++)
        {
            if (result[i]==x.length-1 && x[i]<=x[x.length-1])
            {
                result[i]=x.length;
            }
        }
        return result;
    }
}
