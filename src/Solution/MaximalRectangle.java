public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will use the algorithm of maximal rectange in histogram
        // where the histogram is the # of 1s in this column starting from current row
        if (matrix==null || matrix.length<1 || matrix[0]==null || matrix[0].length<1)
        {
            return 0;
        }
        int[][]height=new int[matrix.length][matrix[0].length];
        int max=0;
        for (int i=matrix.length-1; i>=0; i--)
        {
            for(int j=0; j<matrix[i].length; j++)
            {
                if (matrix[i][j]=='0')
                {
                    height[i][j]=0;
                }
                else if (i==matrix.length-1)
                {
                    height[i][j]=1;
                }
                else
                {
                    height[i][j]=height[i+1][j]+1;
                }
            }
            int area=largestRectangleArea(height[i]);
            if (area>max)
            {
                max=area;
            }
        }
        return max;
        
    }
    
    public int largestRectangleArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will have o(n) solution
        // assume we have two array left and right, where
        // left[i]=max{j: height[j]<height[i] & j<=i}
        // right[i]=min{j: height[j]<height[i] & j>=i}
        // then we need to look for max{i: (right[i]-left[i]-1)*height[i]}
        if (height==null || height.length<1)
        {
            return 0;
        }
        int []left=findLeft(height);
        int []right=findRight(height);
        int max=0;
        for (int i=0; i<height.length; i++)
        {
            int width=right[i]-left[i]-1;
            if (height[i]<=height[right[i]])
            {
                width++;
            }
            if (height[i]<=height[left[i]])
            {
                width++;
            }
            int area=width*height[i];
            if (area>max)
            {
                max=area;
            }
        }
        return max;
    }
    
    // left[i]=max{j: height[j]<height[i] & j<=i}
    // the largest index on the left whose value is smaller than the current one
    private int[] findLeft(int []height)
    {
        int []left=new int[height.length];
        // stack stores the index of previous minimal element
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(0);
        for (int i=1; i<height.length; i++)
        {
            // simplest case
            if (height[i]>height[i-1])
            {
                left[i]=i-1;
            }
            else
            {
                while(!stack.isEmpty() && height[i]<=height[stack.peek()])
                {
                    stack.pop();
                }
                // height[i] is the smallest element in the stack
                if (stack.isEmpty())
                {
                    left[i]=0;
                }
                else
                {
                    left[i]=stack.peek();
                }
            }
            stack.push(i);
        }
        return left;
    }
    
    private int[] findRight(int []height)
    {
        int []right=new int[height.length];
        // stack stores the index of previous minimal element
        Stack<Integer> stack=new Stack<Integer>();
        stack.push(height.length-1);
        right[height.length-1]=height.length-1;
        for (int i=height.length-2; i>=0; i--)
        {
            if (height[i]>height[i+1])
            {
                right[i]=i+1;
            }
            else
            {
                while(!stack.isEmpty() && height[i]<=height[stack.peek()])
                {
                    stack.pop();
                }
                if (stack.isEmpty())
                {
                    right[i]=height.length-1;
                }
                else
                {
                    right[i]=stack.peek();
                }
            }
            stack.push(i);
        }
        return right;
    }
}
