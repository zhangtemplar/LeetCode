package trial3;

import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
        /*
        the idea is simple: we use a stack, once we met a operator, we push it into stack;
        once we met a operand, we make two pops and compute the result, which is then pushed into stacked
        return the result onces the stack is empty
        */
        Stack<Integer> stack=new Stack<Integer>();
        // empty case
        if (tokens==null || tokens.length<1)
        {
            return 0;
        }
        // single operand
        else if (tokens.length==1)
        {
            // we need to take exception here
            if (isNumeric(tokens[0]))
            {
                return Integer.parseInt(tokens[0]);
            }
            else
            {
                return 0;
            }
        }
        // other cases
        else
        {
            if (isNumeric(tokens[0]))
            {
                stack.push(Integer.parseInt(tokens[0]));
            }
            else
            {
                return 0;
            }
            if (isNumeric(tokens[1]))
            {
                stack.push(Integer.parseInt(tokens[1]));
            }
            else
            {
                return 0;
            }
            for(int i=2; i<tokens.length; i++)
            {
                // operator
                if (isNumeric(tokens[i]))
                {
                    stack.push(Integer.parseInt(tokens[i]));
                }
                // operand
                else
                {
                    int left, right;
                    if (!stack.isEmpty())
                    {
                        right=stack.pop();
                    }
                    else
                    {
                        return 0;
                    }
                    if (!stack.isEmpty())
                    {
                        left=stack.pop();
                    }
                    else
                    {
                        return 0;
                    }
                    // do the computation
                    // take care of the overflow
                    switch (tokens[i])
                    {
                        case "+":
                            stack.push(left+right);
                            break;
                        case "-":
                            stack.push(left-right);
                            break;
                        case "*":
                            stack.push(left*right);
                            break;
                        case "/":
                            stack.push(left/right);
                            break;
                        default:
                            return 0;
                    }
                }
            }
            // at the end, make sure there is one and only one element in the stack
            if (stack.size()==1)
            {
                return stack.pop();
            }
            else
            {
                return 0;
            }
        }
        
    }
    
    private boolean isNumeric(String str)
    {
        if (str.equals("+") || str.equals("-") || str.equals("/") || str.equals("*"))
        {
            return false;
        }
        return true;
    }
}
