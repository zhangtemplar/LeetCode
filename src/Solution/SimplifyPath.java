import java.util.StringTokenizer;

public class Solution {
    public String simplifyPath(String path) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we could use a stack for this purpose, we seperate each string with /
        // if we met ., we ignore it, if we met .., we pop the stack
        if (path==null || path.length()<1)
        {
            return path;
        }
        Stack<String> stack=new Stack<String>();
        StringTokenizer token=new StringTokenizer(path, "/");
        while(token.hasMoreTokens())
        {
            String str=token.nextToken();
            if (str.equals(".."))
            {
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else if(str.equals("."))
            {
                // do nothing
            }
            else
            {
                stack.push(str);
            }
        }
        if (stack.isEmpty())
        {
            return new String("/");
        }
        // simply the path
        StringBuffer result=new StringBuffer();
        while(!stack.isEmpty())
        {
            result.insert(0, stack.pop());
            result.insert(0, "/");
        }
        return result.toString();
    }
}
