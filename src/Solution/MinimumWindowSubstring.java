package Solution;

import java.util.Arrays;

public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring instance=new MinimumWindowSubstring();
		System.out.println(instance.minWindowFast("xeaifhaqslynbcwxncwgeezbrjorzyuwevejcecuscjvgfutkrcqxbromihlgcjnzpybwcxqeglknhgzyiqxljnyrvlazvnyklbgoywugjftrltrvlrgueeobsoandazqbigbgbhqgdjtycojtwfydtbvjekmejdirjlymvquybnyddjxaoxfkyatckijvlrnwcnjxfdxgtvjweiyvfdhefaipkrnviaunpfmukkcdhlcmwcjbgqhnsqfdhsasuwhjbtfmdhrluvzqykugcbtutyzdqcxkyevaxcodjhogdpwbzsjducxpdzsvbpizvfbtirwtzmzebyhcqqfmueczdwveofgjkhesbamaolgrlpvcfcqbhubmtythdzspizijbwlqjrjvgfznhprqmudfsyoxzimhhutjsebcykxgpywznnpbhuizuwythkbohwzzacbanyhewdfmsvpzryamuyhdkkurgvrjysjntqrrvxfnuvonvqbrqjvbvpucklligu", "xbnpukocakzqzuhdlxoga"));
		System.out.println(instance.minWindow("xeaifhaqslynbcwxncwgeezbrjorzyuwevejcecuscjvgfutkrcqxbromihlgcjnzpybwcxqeglknhgzyiqxljnyrvlazvnyklbgoywugjftrltrvlrgueeobsoandazqbigbgbhqgdjtycojtwfydtbvjekmejdirjlymvquybnyddjxaoxfkyatckijvlrnwcnjxfdxgtvjweiyvfdhefaipkrnviaunpfmukkcdhlcmwcjbgqhnsqfdhsasuwhjbtfmdhrluvzqykugcbtutyzdqcxkyevaxcodjhogdpwbzsjducxpdzsvbpizvfbtirwtzmzebyhcqqfmueczdwveofgjkhesbamaolgrlpvcfcqbhubmtythdzspizijbwlqjrjvgfznhprqmudfsyoxzimhhutjsebcykxgpywznnpbhuizuwythkbohwzzacbanyhewdfmsvpzryamuyhdkkurgvrjysjntqrrvxfnuvonvqbrqjvbvpucklligu", "xbnpukocakzqzuhdlxoga"));
		System.out.println(instance.minWindowSlow("xeaifhaqslynbcwxncwgeezbrjorzyuwevejcecuscjvgfutkrcqxbromihlgcjnzpybwcxqeglknhgzyiqxljnyrvlazvnyklbgoywugjftrltrvlrgueeobsoandazqbigbgbhqgdjtycojtwfydtbvjekmejdirjlymvquybnyddjxaoxfkyatckijvlrnwcnjxfdxgtvjweiyvfdhefaipkrnviaunpfmukkcdhlcmwcjbgqhnsqfdhsasuwhjbtfmdhrluvzqykugcbtutyzdqcxkyevaxcodjhogdpwbzsjducxpdzsvbpizvfbtirwtzmzebyhcqqfmueczdwveofgjkhesbamaolgrlpvcfcqbhubmtythdzspizijbwlqjrjvgfznhprqmudfsyoxzimhhutjsebcykxgpywznnpbhuizuwythkbohwzzacbanyhewdfmsvpzryamuyhdkkurgvrjysjntqrrvxfnuvonvqbrqjvbvpucklligu", "xbnpukocakzqzuhdlxoga"));
	}

	public String minWindowFast(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function/
        // we use brute force search, where the complexity is O(N^2)
        if (T==null || T.length()<1)
        {
            return new String("");
        }
        else if (S==null || S.length()<1 || S.length()<T.length())
        {
            return new String("");
        }
        else
        {
            // build the pattern
        	QuickCountTable<Character> target=new QuickCountTable<Character>();
            for (int i=0; i<T.length(); i++)
            {
            	target.add(T.charAt(i));
            }
            for (int i=0; i<T.length(); i++)
            {
            	target.decrease(S.charAt(i));
            }
            int min_start, min_end;
            min_start=-1;
            min_end=S.length()+1;
            boolean found=false;
            int start, end;
            start=0;
            end=T.length();
            while(end<=S.length())
            {
                // we found a potential window
                // check whether it is the smallest
                if (target.isValid())
                {
                    if ((min_end-min_start)>(end-start))
                    {
                        min_start=start;
                        min_end=end;
                        found=true;
                    }
                    // find a new window by shrinking the window by 1 on the left
                    target.increase(S.charAt(start));
                    start++;
                }
                else if (end<S.length())
                {
                    // we need to expand the window by 1 on the right
                    target.decrease(S.charAt(end));
                    end++;
                }
                else
                {
                	break;
                }
            }
            if (found)
            {
                return S.substring(min_start, min_end);
            }
            else
            {
                return new String("");
            }
        }
    }
	
	public String minWindow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function/
        // we use brute force search, where the complexity is O(N^2)
        if (T==null || T.length()<1)
        {
            return new String("");
        }
        else if (S==null || S.length()<1 || S.length()<T.length())
        {
            return new String("");
        }
        else
        {
            // build the pattern
            int[] target=new int[256];
            for (int i=0; i<T.length(); i++)
            {
                target[T.charAt(i)]++;
                target[S.charAt(i)]--;
            }
            int min_start, min_end;
            min_start=-1;
            min_end=S.length()+1;
            boolean found=false;
            // instead of check the target for each possible sliding window
            // we record the first unmatch of the target
            // if the current change of the sliding window fix this unmatch
            // then we check the match of this sliding window
            // otherwise, we skip it
            int last_unmatch=-1;
            int start, end;
            start=0;
            end=T.length();
            while(end<=S.length())
            {
                // we found a potential window
                // check whether it is the smallest
            	if (last_unmatch<0 || target[last_unmatch]<=0)
            	{
            		last_unmatch=isValid(target);
            	}
                if (last_unmatch<0)
                {
                    if ((min_end-min_start)>(end-start))
                    {
                        min_start=start;
                        min_end=end;
                        found=true;
                    }
                    // find a new window by shrinking the window by 1 on the left
                    target[S.charAt(start)]++;
                    start++;
                }
                else if (end<S.length())
                {
                    // we need to expand the window by 1 on the right
                    target[S.charAt(end)]--;
                    end++;
                }
                else
                {
                	break;
                }
            }
            if (found)
            {
                return S.substring(min_start, min_end);
            }
            else
            {
                return new String("");
            }
        }
    }
    
    private int isValid(int[] target)
    {
    	int result=-1;
        for (int i=0; i<target.length; i++)
        {
            if (target[i]>0)
            {
                return i;
            }
        }
        return result;
    }
    
	public String minWindowSlow(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function/
        // we use brute force search, where the complexity is O(N^2)
        if (T==null || T.length()<1)
        {
            return new String("");
        }
        else if (S==null || S.length()<1)
        {
            return new String("");
        }
        else
        {
            // build the pattern
            int[] target=new int[256];
            for (int i=0; i<T.length(); i++)
            {
                target[T.charAt(i)]++;
            }
            // we use brute force search
            boolean founded=false;
            for (int i=T.length(); i<=S.length(); i++)
            {
                int[] digits=Arrays.copyOf(target, target.length);
                // check the string within range [j, i+j)
                // we can use cumulative search method
                // inital: [0, i)
                for (int j=0; j<i; j++)
                {
                    digits[S.charAt(j)]--;
                }
                // we found the solution
                founded=true;
                for (int k=0; k<digits.length; k++)
                {
                    founded=founded&(digits[k]<=0);
                }
                if (founded)
                {
                    return S.substring(0, i);
                }
                // the main
                for (int j=1; j+i<=S.length(); j++)
                {
                    digits[S.charAt(j-1)]++;
                    digits[S.charAt(j+i-1)]--;
                    // check the solution
                    founded=true;
                    for (int k=0; k<digits.length; k++)
                    {
                        founded=founded&(digits[k]<=0);
                    }
                    if (founded)
                    {
                        return S.substring(j, i+j);
                    }
                }
            }
            return new String("");
        }
    }
}
