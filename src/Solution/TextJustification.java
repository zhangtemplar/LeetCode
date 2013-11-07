public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<String> result=new ArrayList<String>();
        if (words==null || words.length<1 || L<0)
        {
            return result;
        }
        int i=0;
        while(i<words.length)
        {
            // find the set of words forms the current line
            int count=0;
            int j=i;
            while(j<words.length && count+words[j].length()+(j-i)<=L)
            {
                count+=words[j].length();
                j++;
            }
            StringBuffer line=new StringBuffer();
            // L is too small to fit one word
            if (j==i)
            {
                return new ArrayList<String>();
            }
            // the last line
            else if (j>=words.length || j==i+1)
            {
                for (int l=i; l<j; l++)
                {
                    if (l!=i)
                    {
                        line.append(" ");
                    }
                    line.append(words[l]);
                }
                // add the space when necessary
                for (int l=count+(j-i-1); l<L; l++)
                {
                    line.append(" ");
                }
                result.add(line.toString());
            }
            else
            {
                // compute the # of space for the empty slots
                int space=(L-count)/(j-i-1);
                int seperator=L-count-space*(j-i-1);
                char []slot=new char[space];
                for (int l=0; l<slot.length; l++)
                {
                    slot[l]=' ';
                }
                String slots=new String(slot);
                for (int l=i; l<j; l++)
                {
                    // we make sure the left part has no fewer spaces than right
                    if (l!=i && l-i<=seperator)
                    {
                        line.append(slots);
                        line.append(" ");
                    }
                    // for right part
                    else if(l!=i)
                    {
                        line.append(slots);
                    }
                    line.append(words[l]);
                }
                result.add(line.toString());
            }
            i=j;
        }
        return result;
    }
}
