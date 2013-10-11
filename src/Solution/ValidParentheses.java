public class Solution {
    public boolean isValid(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we may use a stack for this purpose, whenever we see (, [, or {, we push into the stack
        // whenever we see a ), ], }, we check the stack, if there is corresponding (, [, or { in
        // the top, we pop it out, otherwise report error. Finally, check whether the stack is empty
        // or not
        if (s==null || s.length()<1)
        {
            return true;
        }
        Stack<Character> stack=new Stack<Character>();
        HashMap<Character, Character> match=new HashMap<Character, Character>();
        match.put(')', '(');
        match.put(']', '[');
        match.put('}', '{');
        match.put('(', ')');
        match.put('[', ']');
        match.put('{', '}');
        for (int i=0; i<s.length(); i++)
        {
            char c=s.charAt(i);
            if (c=='(' || c=='[' || c=='{')
            {
                stack.push(c);
            }
            else if (c==')' || c==']' || c=='}')
            {
                if (stack.isEmpty() || !match.get(c).equals(stack.peek()))
                {
                    return false;
                }
                else
                {
                    stack.pop();
                }
            }
            else
            {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
