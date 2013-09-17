package Solution;

import java.util.ArrayList;
import java.util.Arrays;

public class TextJustification {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TextJustification instance=new TextJustification();
		String[] words={"Here","is","an","example","of","text","justification."};
		ArrayList<String> result=instance.fullJustify(words, 16);
		System.out.println(result);
	}

	public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> result=new ArrayList<String>();
        if (words==null || words.length<1 || L<1)
        {
            result.add(new String());
            return result;
        }
        // main algorithm
        // the current word and the word of the head
        int i=0;
        int j=0;
        int len=0;
        while (i<words.length)
        {
            if (len+words[i].length()>L)
            {
                // the words in range [j i) forms a line
                if (i==j)
                {
                    // we would fail the case
                    // because we not even pack the a single words in a line
                    return result;
                }
                else
                {
                    StringBuffer line=new StringBuffer();
                    if (i-j-1==0)
                    {
                        line.append(words[j]);
                        // append space after
                        char []spaces=new char[L-words[j].length()];
                        Arrays.fill(spaces, ' ');
                        line.append(spaces);
                    }
                    else
                    {
                    	int divisor_space=(L-len+i-j)/(i-j-1);
                        int remain_space=(L-len+i-j)%(i-j-1);
                        for (int k=j; k<i; k++)
                        {
                            if (k>j)
                            {
                                char[] spaces;
                                if (remain_space>k-j-1)
                                {
                                    spaces=new char[divisor_space+1];
                                }
                                else
                                {
                                    spaces=new char[divisor_space];
                                }
                                Arrays.fill(spaces, ' ');
                                line.append(spaces);
                            }
                            line.append(words[k]);
                        }
                    }
                    result.add(line.toString());
                    len=0;
                    j=i;
                }
            }
            else
            {
                // 1 for the must-have space between two words
                len+=words[i].length()+1;
                i++;
            }
        }
        // for the last line
        // we have some words unprocessed
        StringBuffer line=new StringBuffer();
        // we need to evenly distribute the space
        len=0;
        for (int k=j; k<i; k++)
        {
            if (k>j)
            {
                line.append(" ");
                len++;
            }
            line.append(words[k]);
            len+=words[k].length();
        }
        // append spaces to the end
        char []spaces=new char[L-len];
        Arrays.fill(spaces, ' ');
        line.append(spaces);
        result.add(line.toString());
        return result;
    }
}
