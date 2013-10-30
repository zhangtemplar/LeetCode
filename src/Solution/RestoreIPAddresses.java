public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        // we will use backtrace
        if (s==null || s.length()<4)
        {
            return new ArrayList<String>();
        }
        return restoreIpAddresses(s, 0, new ArrayList<Integer>());
    }
    
    /**
     * @param start is the index of char we can use
     */ 
    private ArrayList<String> restoreIpAddresses(String s, int start, ArrayList<Integer> base)
    {
        ArrayList<String> result=new ArrayList<String>();
        // we finish the string
        if (start>=s.length())
        {
            if (base.size()==4)
            {
                StringBuffer str=new StringBuffer();
                str.append(base.get(0));
                str.append('.');
                str.append(base.get(1));
                str.append('.');
                str.append(base.get(2));
                str.append('.');
                str.append(base.get(3));
                result.add(str.toString());
            }
        }
        // the string is not finished yet and the ip address is not complete yet
        // however, we need to avoid '00' of something similar
        else if(base.size()<4)
        {
            ArrayList<Integer> entry=null;
            // we can have triple here
            // 1    the string is not long enough
            // 2    the string has value >255
            // 3    the string has something like 0xx
            if (start+2<s.length() && (s.charAt(start)-'0')*100+(s.charAt(start+1)-'0')*10+(s.charAt(start+2)-'0')<=255 && (s.charAt(start)-'0')*100+(s.charAt(start+1)-'0')*10+(s.charAt(start+2)-'0')>99)
            {
                // add this single char
                entry=new ArrayList<Integer>(base);
                entry.add(s.charAt(start)-'0');
                result.addAll(restoreIpAddresses(s, start+1, entry));
                // also check the two char
                entry=new ArrayList<Integer>(base);
                entry.add((s.charAt(start)-'0')*10+(s.charAt(start+1)-'0'));
                result.addAll(restoreIpAddresses(s, start+2, entry));
                // and triple
                entry=new ArrayList<Integer>(base);
                entry.add((s.charAt(start)-'0')*100+(s.charAt(start+1)-'0')*10+(s.charAt(start+2)-'0'));
                result.addAll(restoreIpAddresses(s, start+3, entry));
            }
            // we can have double
            // 1    the string is not long enough
            // 2    the string is something like 0x
            else if(start+1<s.length() && (s.charAt(start)-'0')*10+(s.charAt(start+1)-'0')>9)
            {
                // add this single char
                entry=new ArrayList<Integer>(base);
                entry.add(s.charAt(start)-'0');
                result.addAll(restoreIpAddresses(s, start+1, entry));
                // also check the two char
                entry=new ArrayList<Integer>(base);
                entry.add((s.charAt(start)-'0')*10+(s.charAt(start+1)-'0'));
                result.addAll(restoreIpAddresses(s, start+2, entry));
            }
            // only single
            else
            {
                // add this single char
                entry=new ArrayList<Integer>(base);
                entry.add(s.charAt(start)-'0');
                result.addAll(restoreIpAddresses(s, start+1, entry));
            }
        }
        return result;
    }
}
