package Solution;

import java.util.Stack;

public class SimplifyPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use stacks to store the path
        if (path==null || path.length()<1)
        {
            return path;
        }
        Stack<String> stack=new Stack<String>();
        int i=1;
        int j=0;
        int flag_dot=0;
        boolean flag_char=false;
        while(i<path.length())
        {
            if (path.charAt(i)=='/')
            {
                // this seperates it from the previous
                if (flag_dot==0 && flag_char)
                {
                    stack.push(path.substring(j, i));
                }
                flag_dot=0;
                flag_char=false;
                j=i;
            }
            else if (path.charAt(i)=='.')
            {
                if (flag_dot==1)
                {
                    // this is ..
                    if (!stack.isEmpty())
                    {
                        stack.pop();
                    }
                    flag_dot++;
                }
                else if(flag_dot==0)
                {
                    flag_dot++;
                }
                else
                {
                    // error case
                    flag_dot++;
                    break;
                }
            }
            else
            {
                flag_dot=0;
                flag_char=true;
            }
            // a single dot and the other cases can be skipped
            i++;
        }
        // post-processing
        // if the last segement is not ended with / or ,
        if (flag_dot==0 && path.charAt(i-1)!='/')
        {
            stack.push(path.substring(j, i));
        }
        // convert it to the string
        StringBuffer result=new StringBuffer();
        if (stack.isEmpty())
        {
            result.append('/');
        }
        else
        {
            while(!stack.isEmpty())
            {
                result.insert(0, stack.pop());
            }
        }
        return result.toString();
    }
}
