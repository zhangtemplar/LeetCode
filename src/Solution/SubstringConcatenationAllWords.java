public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we can preprocess the S such that given i, we will find whether there is j such that L[j]==S[i:i+m]
        if (S==null || L==null || L.length<1 || S.length()<L[0].length())
        {
            return new ArrayList<Integer>();
        }
        // to deal with potential duplicate, we first count the number of words there
        HashMap<String, Integer> dict=new HashMap<String, Integer>();
        for (String str: L)
        {
            if (dict.containsKey(str))
            {
                dict.put(str, dict.get(str)+1);
            }
            else
            {
                dict.put(str, 1);
            }
        }
        // preprocessing
        String[] L2=(String[]) java.lang.reflect.Array.newInstance(L[0].getClass(), dict.keySet().size());
        dict.keySet().toArray(L2);
        int []match=processString(S, L2);
        // the problem now becomes that, find a subwindow which contains a permuation of array 0:n-1
        StringTable buffer=new StringTable();
        int i=0;
        int j=0;
        ArrayList<Integer> result=new ArrayList<Integer>();
        while(i<match.length)
        {
            // a mismtach or a duplicated match found
            if (match[i]<0 || (buffer.containsKey(match[i]) && buffer.get(match[i])>=dict.get(L2[match[i]])))
            {
                // finish a match
                if (buffer.count==L.length)
                {
                    result.add(j);
                }
                buffer=new StringTable();
                i=j+1;
                j=i;
            }
            // a new match, add this to the buffer
            else
            {
                buffer.add(match[i]);
                // jump to the next position
                i+=L[0].length();
            }
        }
        if (buffer.count==L.length)
        {
            result.add(j);
        }
        return result;
    }
    
    /**
     * we assume there is no duplicate in L
     * 
     */ 
    private int[] processString(String S, String[] L)
    {
        int[] result=new int[S.length()];
        for (int i=0; i<S.length(); i++)
        {
            result[i]=-1;
            if (i+L[0].length()>S.length())
            {
                continue;
            }
            String str=S.substring(i, i+L[0].length());
            for (int j=0; j<L.length; j++)
            {
                if (L[j].equals(str))
                {
                    result[i]=j;
                    break;
                }
            }
        }
        return result;
    }
}

class StringTable
{
    public HashMap<Integer, Integer> buffer;
    public int count;
    public StringTable()
    {
        buffer=new HashMap<Integer, Integer>();
        count=0;
    }
    
    public void add(int x)
    {
        if (buffer.containsKey(x))
        {
            buffer.put(x, buffer.get(x)+1);
        }
        else
        {
            buffer.put(x, 1);
        }
        count++;
    }
    
    public int get(int key)
    {
    	return buffer.get(key);
    }
    
    public boolean containsKey(int key)
    {
    	return buffer.containsKey(key);
    }
}
