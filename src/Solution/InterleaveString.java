public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // back trace
        if (s1==null || s1.length()<1)
        {
            if (s2==null || s2.length()<1)
            {
                return s3==null || s3.length()<1;
            }
            else if (s3==null || s3.length()<1)
            {
                return false;
            }
            else if (s2.length()!=s3.length())
            {
                return false;
            }
        }
        else if (s2==null || s2.length()<1)
        {
            if (s3==null || s3.length()<1)
            {
                return false;
            }
            else if (s1.length()!=s3.length())
            {
                return false;
            }
        }
        else if (s3==null || s3.length()<1)
        {
            return false;
        }
        else if (s1.length()+s2.length()!=s3.length())
        {
            return false;
        }
        return isInterleave(s1, 0, s2, 0, s3, new HashMap<Integer, Boolean>());
    }
    
    private boolean isInterleave(String s1, int start1, String s2, int start2, String s3, HashMap<Integer, Boolean> buffer)
    {
        if (buffer.containsKey(start1+start2*s1.length()))
        {
            return buffer.get(start1+start2*s1.length());
        }
        // match complete
        if (start1>=s1.length() && start2>=s2.length())
        {
            return true;
        }
        else
        {
            // check the current
            if (start1<s1.length() && s1.charAt(start1)==s3.charAt(start1+start2) && isInterleave(s1, start1+1, s2, start2, s3, buffer))
            {
                buffer.put(start1+start2*s1.length(), true);
                return true;
            }
            if (start2<s2.length() && s2.charAt(start2)==s3.charAt(start1+start2) && isInterleave(s1, start1, s2, start2+1, s3, buffer))
            {
                buffer.put(start1+start2*s1.length(), true);
                return true;
            }
            buffer.put(start1+start2*s1.length(), false);
            return false;
        }
    }
}
