public class Solution {
    public String intToRoman(int num) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        HashMap<Integer, Character> value=new HashMap<Integer, Character>();
        value.put(1, 'I');
        value.put(5, 'V');
        value.put(10, 'X');
        value.put(50, 'L');
        value.put(100, 'C');
        value.put(500, 'D');
        value.put(1000, 'M');
        int digit=0;
        int base=1;
        StringBuffer result=new StringBuffer();
        while(num>0)
        {
            digit=num%10;
            if (digit<4)
            {
                for (int i=1; i<=digit; i++)
                {
                    result.insert(0, value.get(base));
                }
            }
            else if(digit==4)
            {
                result.insert(0, value.get(base*5));
                result.insert(0, value.get(base));
            }
            else if(digit==5)
            {
                result.insert(0, value.get(base*5));
            }
            else if(digit<9)
            {
                for (int i=6; i<=digit; i++)
                {
                    result.insert(0, value.get(base));
                }
                result.insert(0, value.get(base*5));
            }
            else
            {
                result.insert(0, value.get(base*10));
                result.insert(0, value.get(base));
            }
            num=num/10;
            base=base*10;
        }
        return result.toString();
    }
}
