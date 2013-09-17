package Solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Anagram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anagram instance=new Anagram();
		String[] str={"",""};
		System.out.println(instance.anagrams(str));
	}

	public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we will use a Hashmap, where the key is the char count and value is string
        if (strs==null || strs.length<1)
        {
            return new ArrayList<String>();
        }
        HashSet<StringCount> table=new HashSet<StringCount>();
        ArrayList<String> result=new ArrayList<String>();
        for (String str: strs)
        {
        	StringCount new_entry=new StringCount(str);
            if (!table.contains(new_entry))
            {
                table.add(new_entry);
            }
            else
            {
            	result.add(str);
            }
        }
        return result;
    }
    

}

class StringCount
{
	String str;
	int []letter;
	int count;
	public StringCount(String s)
	{
		str=s;
		letter=countChar(str);
		count=0;
	}
	
    private int[] countChar(String str)
    {
        int []result=new int[26];
        for (int i=0; i<str.length(); i++)
        {
            result[str.charAt(i)-'a']++;
        }
        return result;
    }
    
	public String toString()
	{
		return new String(count+" "+str);
	}
	
	public boolean equals(Object obj)
	{
		if (obj instanceof StringCount)
		{
			StringCount obj2=(StringCount) obj;
			for(int i=0; i<letter.length; i++)
			{
				if (letter[i]!=obj2.letter[i])
				{
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public int hashCode()
	{
		int result=0;
		for (int i=0; i<letter.length; i++)
		{
			result+=letter[i]*(i+'a');
		}
		return result;
	}
}
