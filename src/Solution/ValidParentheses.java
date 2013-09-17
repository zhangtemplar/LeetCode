package Solution;

import java.util.Stack;

public class ValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use a stack for this problem:
        // if we meet left parentheses, we push into the stack
        // else if we meet right parentheses, we pop the stack
        //      if the poped out element matches, continue;
        //      otherwise return false
        // otherwise return false
        if (s==null || s.length()<1)
        {
            return true;
        }
        Stack<Character> stack=new Stack<Character>();
        char s_new, s_prev;
        for (int i=0; i<s.length(); i++)
        {
            s_new=s.charAt(i);
            if (patterns[s_new]<0)
            {
                // left one
                stack.push(s_new);
            }
            else if (patterns[s_new]>0)
            {
                // right one, check whether it matches with top of the stack
                if (stack.isEmpty())
                {
                    // the stack is empty, an error case
                    return false;
                }
                else
                {
                    s_prev=stack.pop();
                    if (patterns[s_new]+patterns[s_prev]!=0)
                    {
                        // don't match
                        return false;
                    }
                    // otherwise continue;
                }
            }
            else
            {
                // illegal letter
                return false;
            }
        }
        // finally check the stack, if is not empty, return false;
        return stack.isEmpty();
    }
    
    private static final int[]patterns={0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    -1,+1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    -2,0,+2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,
    -3,0,+3,0,0};
}
