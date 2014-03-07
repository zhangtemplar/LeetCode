package trial3;

import java.util.ArrayList;

public class ReverseWordsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
     * an intuitive solution: convert the string to a list of words
     * return the words
     */
    public String reverseWords(String s) {
        if (s==null || s.length()<1)
        {
            return s;
        }
        ArrayList<String> words=new ArrayList<String>();
        int j=0;
        for (int i=0; i<s.length(); i++)
        {
            // this should finish a word
            if (s.charAt(i)==' ')
            {
                // this is a word
                if (s.charAt(j)!=' ' && i!=j)
                {
                    words.add(s.substring(j, i));
                }
                j=i+1;
            }
        }
        // in case the last word finish without a space
        if (j<s.length() && s.charAt(j)!=' ')
        {
            words.add(s.substring(j, s.length()));
        }
        // create the new string
        StringBuilder result=new StringBuilder();
        for (int i=words.size()-1; i>=0; i--)
        {
            result.append(words.get(i));
            if (i>0)
            {
                result.append(' ');
            }
        }
        return result.toString();
    }
}
