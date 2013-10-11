public class Solution {
    public int lengthOfLastWord(String s) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        // we can search from the end of the string
        if (s==null || s.length()<1)
        {
            return 0;
        }
        int word_detect=-1;
        int i=0;
        for (i=s.length()-1; i>=0; i--)
        {
            // space detected
            if (s.charAt(i)==' ')
            {
                // we have detect a word
                if (word_detect>=0)
                {
                    return word_detect-i;
                }
            }
            else if (word_detect<0)
            {
                word_detect=i;
            }
        }
        // no word detected (word_detect=-1) or there is only one word there
        return word_detect-i;
    }
}
