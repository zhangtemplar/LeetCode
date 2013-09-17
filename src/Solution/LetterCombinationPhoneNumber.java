package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class LetterCombinationPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> letterCombinations(String digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        // we propose to recursion
        // f(digits[0:n])=U_i{f(digits[1:n]) key[digits[0]][i]}
        ArrayList<String> result=new ArrayList<String>();
        if (digits==null)
        {
            // illegal input
            return result;
        }
        else if (digits.length()<1)
        {
            result.add(new String(""));
            return result;
        }
        // all the common case
        // we use char[] for efficiency consideration
        ArrayList<char[]> strings=digitLetter(digits, 0);
        // convert char[] to string
        for (char[] str: strings)
        {
            result.add(new String(str));
        }
        return result;
    }
    
    /**
     * the string will be processed from the end to the beginning
     */
    private ArrayList<char[]> digitLetter(String digits, int i)
    {
        ArrayList<char[]> result=new ArrayList<char[]>();
        int d;
        if (i>=digits.length())
        {
            // error case, should never happen
        }
        else if (i==digits.length()-1)
        {
            // base cases
            d=digits.charAt(i)-'0';
            // just build the array, however only fill in the last letter
            for (char s: key[d])
            {
                char []new_letter=new char[digits.length()];
                new_letter[i]=s;
                result.add(new_letter);
            }
        }
        else
        {
            // other cases
            d=digits.charAt(i)-'0';
            ArrayList<char[]> str=digitLetter(digits, i+1);
            // start from the previous result
            for (char s: key[d])
            {
                // for each possible letter for that key
                for (char[] letter: str)
                {
                    char [] new_letter=Arrays.copyOf(letter, letter.length);
                    new_letter[i]=s;
                    result.add(new_letter);
                }
            }
        }
        return result;
    }
    
    private static final char[][] key={{' '},
    {' '},
    {'a', 'b', 'c'},
    {'d', 'e', 'f'},
    {'g', 'h', 'i'},
    {'j', 'k', 'l'},
    {'m', 'n', 'o'},
    {'p', 'q', 'r', 's'},
    {'t', 'u', 'v'},
    {'w', 'x', 'y', 'z'}};
}
