package Solution;

import java.util.Stack;

public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestValidParentheses(String s) {
		// Start typing your Java solution below
        // DO NOT write main() function
        // we will use the stack to store the result
        // if we meet left, we push into the stack
        // if we meet right, we check the top,
        //      if it is left, we pop it out and increase counter by 2
        //      otherwise, we know the valid parenthese terminate here and reset count
        // check the input
        if (s==null || s.length()<2)
        {
            return 0;
        }
        // stack to store the parenthese
        Stack<Integer> stack=new Stack<Integer>();
        int result=0;
        int count=0;;
        int i;
        for (i=0; i<s.length(); i++)
        {
            if (s.charAt(i)=='(')
            {
                stack.push(count);
            }
            else if (s.charAt(i)==')')
            {
                // check the stack first
                if (!stack.isEmpty())
                {
                    // it is a left
                    stack.pop();
                    count+=2;
                }
                else
                {
                    // save the previous result best
                    if (result<count)
                    {
                        result=count;
                    }
                    // there is no valid left there
                    // clear the stack, reset the counter
                    stack.clear();
                    count=0;
                }
            }
            else
            {
                // illegal input here
                break;
            }
        }
        // post-processing: for the unmatched left
        while(!stack.isEmpty())
        {
            if (result<count-stack.peek())
            {
                result=count-stack.peek();
            }
            count=stack.pop();
        }
        if (result<count)
        {
            result=count;
        }
        // result
        return result;
    }
}
